package com.artos.tests.utils_tcp_server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.artos.annotation.TestCase;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.ConnectableFilter;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.TCPClient;
import com.artos.utils.TCPServer;
import com.artos.utils.Transform;

@TestCase(skip = false, sequence = 0)
public class Test_Server_Client_Merged_Msgs implements TestExecutable {
	TCPServer server;

	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		Transform _transform = new Transform();

		// Create Server filter
		ConnectableFilter filter = new ConnectableFilter() {
			@Unit
			public boolean meetCriteria(byte[] data) {
				if (Arrays.equals(data, _transform.strHexToByteArray("00 00 00 04 01 02 03 04"))) {
					return true;
				}
				return false;
			}
		};

		context.getLogger().debug("\nServer Filter disabled + msg parser is provided");
		ExecuteServerTest(context, false, null);
		context.getLogger().debug("\nnServer Filter enabled + msg parser is provided");
		ExecuteServerTest(context, true, filter);

		context.getLogger().debug("\nClient Filter disabled + msg parser is provided");
		ExecuteClientTest(context, false, null);
		context.getLogger().debug("\nClient Filter enabled + msg parser is provided");
		ExecuteClientTest(context, true, filter);
		// --------------------------------------------------------------------------------------------

	}

	private void ExecuteServerTest(TestContext context, boolean enableFilter, ConnectableFilter filter)
			throws UnknownHostException, IOException, InterruptedException {
		Transform _transform = new Transform();
		List<ConnectableFilter> filterListServer = new ArrayList<>();

		if (null != filter) {
			filterListServer.add(filter);
		}

		// Start Server
		Thread t1 = new Thread(new Runnable() {

			@Unit
			public void run() {
				try {
					if (enableFilter) {
						server = new TCPServer(1300, new MsgParser4ByteLength(), filterListServer);
					} else {
						server = new TCPServer(1300, new MsgParser4ByteLength(), null);
					}
					server.connect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();

		TCPClient client = new TCPClient("127.0.0.1", 1300);
		client.connect();

		// MSG which need filtering
		String msg1 = "00 00 00 04 01 02 03 04";

		// Full msg with first 4 bytes as length
		String msg2 = "00 00 00 05 11 22 33 44 55";

		// Full msg with first 4 bytes as length
		String msg3 = "00 00 00 08 11 22 33 44 55 66 77 88";

		// just length
		String msg5 = "00 00 00 04";
		// Just data
		String msg6 = "55 55 55 55";

		// broken length
		String msg7 = "00 00";
		// rest of the msg
		String msg8 = "00 04 99 99 99 99";

		List<byte[]> validationList = new ArrayList<>();
		List<byte[]> returnedList = new ArrayList<>();
		/*
		 * send msg which should be filtered by server
		 */
		client.sendMsg(_transform.strHexToByteArray(msg1));
		Thread.sleep(500);
		if (!enableFilter) {
			validationList.add(_transform.strHexToByteArray(msg1));
		}

		/*
		 * send msg which is single msg
		 */
		client.sendMsg(_transform.strHexToByteArray(msg2));
		Thread.sleep(500);
		validationList.add(_transform.strHexToByteArray(msg2));

		/*
		 * send msg which is merged with other msg
		 */
		client.sendMsg(_transform.strHexToByteArray(msg2 + msg3));
		Thread.sleep(500);
		validationList.add(_transform.strHexToByteArray(msg2));
		validationList.add(_transform.strHexToByteArray(msg3));

		/*
		 * send msg which is merged with other msg and has third msg length only and second msg brings data
		 */
		client.sendMsg(_transform.strHexToByteArray(msg2 + msg3 + msg5));
		Thread.sleep(500);
		client.sendMsg(_transform.strHexToByteArray(msg6));
		Thread.sleep(500);
		validationList.add(_transform.strHexToByteArray(msg2));
		validationList.add(_transform.strHexToByteArray(msg3));
		validationList.add(_transform.strHexToByteArray(msg5 + msg6));

		/*
		 * send single msg again
		 */
		client.sendMsg(_transform.strHexToByteArray(msg1));
		Thread.sleep(500);
		if (!enableFilter) {
			validationList.add(_transform.strHexToByteArray(msg1));
		}

		/*
		 * Send only length and then data in subsequent msg
		 */
		client.sendMsg(_transform.strHexToByteArray(msg5));
		Thread.sleep(500);
		client.sendMsg(_transform.strHexToByteArray(msg6));
		Thread.sleep(500);
		validationList.add(_transform.strHexToByteArray(msg5 + msg6));

		/*
		 * Send only length and then data which is merged with other msg in subsequent msg
		 */
		client.sendMsg(_transform.strHexToByteArray(msg5));
		Thread.sleep(500);
		client.sendMsg(_transform.strHexToByteArray(msg6 + msg2));
		Thread.sleep(500);
		validationList.add(_transform.strHexToByteArray(msg5 + msg6));
		validationList.add(_transform.strHexToByteArray(msg2));

		/*
		 * Send only partial length and then data which is merged with other msg in subsequent msg
		 */
		client.sendMsg(_transform.strHexToByteArray(msg7));
		Thread.sleep(500);
		client.sendMsg(_transform.strHexToByteArray(msg8 + msg1));
		Thread.sleep(500);
		validationList.add(_transform.strHexToByteArray(msg7 + msg8));
		if (!enableFilter) {
			validationList.add(_transform.strHexToByteArray(msg1));
		}

		for (int i = 0; i < validationList.size(); i++) {
			returnedList.add(server.getNextMsg(2000, TimeUnit.MILLISECONDS));
		}

		client.disconnect();
		server.disconnect();

		for (int i = 0; i < validationList.size(); i++) {
			context.getLogger().debug("EXPECTED : " + _transform.bytesToHexString(validationList.get(i), true));
			context.getLogger().debug("RETURNED : " + _transform.bytesToHexString(returnedList.get(i), true));

			if (!Arrays.equals(validationList.get(i), returnedList.get(i))) {
				context.setTestStatus(TestStatus.FAIL, "Sent and Received Data did not match");
			}
		}
	}

	private void ExecuteClientTest(TestContext context, boolean enableFilter, ConnectableFilter filter)
			throws UnknownHostException, IOException, InterruptedException {
		Transform _transform = new Transform();
		List<ConnectableFilter> filterListClient = new ArrayList<>();

		if (null != filter) {
			filterListClient.add(filter);
		}

		// Start Server
		Thread t1 = new Thread(new Runnable() {

			@Unit
			public void run() {
				try {
					server = new TCPServer(1300);
					server.connect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();

		TCPClient client = null;
		if (enableFilter) {
			client = new TCPClient("127.0.0.1", 1300, new MsgParser4ByteLength(), filterListClient);
		} else {
			client = new TCPClient("127.0.0.1", 1300, new MsgParser4ByteLength(), null);
		}
		client.connect();

		// MSG which need filtering
		String msg1 = "00 00 00 04 01 02 03 04";

		// Full msg with first 4 bytes as length
		String msg2 = "00 00 00 05 11 22 33 44 55";

		// Full msg with first 4 bytes as length
		String msg3 = "00 00 00 08 11 22 33 44 55 66 77 88";

		// just length
		String msg5 = "00 00 00 04";
		// Just data
		String msg6 = "55 55 55 55";

		// broken length
		String msg7 = "00 00";
		// rest of the msg
		String msg8 = "00 04 99 99 99 99";

		List<byte[]> validationList = new ArrayList<>();
		List<byte[]> returnedList = new ArrayList<>();
		/*
		 * send msg which should be filtered by server
		 */
		server.sendMsg(_transform.strHexToByteArray(msg1));
		Thread.sleep(500);
		if (!enableFilter) {
			validationList.add(_transform.strHexToByteArray(msg1));
		}

		/*
		 * send msg which is single msg
		 */
		server.sendMsg(_transform.strHexToByteArray(msg2));
		Thread.sleep(500);
		validationList.add(_transform.strHexToByteArray(msg2));

		/*
		 * send msg which is merged with other msg
		 */
		server.sendMsg(_transform.strHexToByteArray(msg2 + msg3));
		Thread.sleep(500);
		validationList.add(_transform.strHexToByteArray(msg2));
		validationList.add(_transform.strHexToByteArray(msg3));

		/*
		 * send msg which is merged with other msg and has third msg length only and second msg brings data
		 */
		server.sendMsg(_transform.strHexToByteArray(msg2 + msg3 + msg5));
		Thread.sleep(500);
		server.sendMsg(_transform.strHexToByteArray(msg6));
		Thread.sleep(500);
		validationList.add(_transform.strHexToByteArray(msg2));
		validationList.add(_transform.strHexToByteArray(msg3));
		validationList.add(_transform.strHexToByteArray(msg5 + msg6));

		/*
		 * send single msg again
		 */
		server.sendMsg(_transform.strHexToByteArray(msg1));
		Thread.sleep(500);
		if (!enableFilter) {
			validationList.add(_transform.strHexToByteArray(msg1));
		}

		/*
		 * Send only length and then data in subsequent msg
		 */
		server.sendMsg(_transform.strHexToByteArray(msg5));
		Thread.sleep(500);
		server.sendMsg(_transform.strHexToByteArray(msg6));
		Thread.sleep(500);
		validationList.add(_transform.strHexToByteArray(msg5 + msg6));

		/*
		 * Send only length and then data which is merged with other msg in subsequent msg
		 */
		server.sendMsg(_transform.strHexToByteArray(msg5));
		Thread.sleep(500);
		server.sendMsg(_transform.strHexToByteArray(msg6 + msg2));
		Thread.sleep(500);
		validationList.add(_transform.strHexToByteArray(msg5 + msg6));
		validationList.add(_transform.strHexToByteArray(msg2));

		/*
		 * Send only partial length and then data which is merged with other msg in subsequent msg
		 */
		server.sendMsg(_transform.strHexToByteArray(msg7));
		Thread.sleep(500);
		server.sendMsg(_transform.strHexToByteArray(msg8 + msg1));
		Thread.sleep(500);
		validationList.add(_transform.strHexToByteArray(msg7 + msg8));
		if (!enableFilter) {
			validationList.add(_transform.strHexToByteArray(msg1));
		}

		for (int i = 0; i < validationList.size(); i++) {
			returnedList.add(client.getNextMsg(2, TimeUnit.SECONDS));
		}

		client.disconnect();
		server.disconnect();

		for (int i = 0; i < validationList.size(); i++) {
			context.getLogger().debug("EXPECTED : " + _transform.bytesToHexString(validationList.get(i), true));
			context.getLogger().debug("RETURNED : " + _transform.bytesToHexString(returnedList.get(i), true));

			if (!Arrays.equals(validationList.get(i), returnedList.get(i))) {
				context.setTestStatus(TestStatus.FAIL, "Sent and Received Data did not match");
			}
		}
	}
}
