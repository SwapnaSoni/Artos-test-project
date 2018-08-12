package unit_test.TCPServer;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.ConnectableFilter;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.TCPClient;
import com.artos.utils.TCPServer;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "3/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_tcp_server_client implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		// Check send receive works between server and client
		Test_Server_Client_Communication(context);

		// Check if msg filtering feature works, there should not be any msg
		// printed
		Test_Server_Client_Filtering(context);

		// Check if user initialise server with fix socket timeout and no client
		// connects within that timeout then sockettimeout exception should be
		// thrown
		try {
			TCPServer server = new TCPServer(1400);
			server.connect(2000);

			// It should timeout in absence of client
			context.setTestStatus(TestStatus.FAIL);
		} catch (SocketTimeoutException e) {
			// Do nothing if socket timeout exception occured
			context.getLogger().info("Exception is as expected");
		}
		// --------------------------------------------------------------------------------------------

	}

	private void Test_Server_Client_Filtering(TestContext context) throws Exception {
		// Create Server filter
		List<ConnectableFilter> filterListServer = new ArrayList<>();
		ConnectableFilter filterServer = new ConnectableFilter() {
			@Override
			public boolean meetCriteria(byte[] data) {
				if (Arrays.equals(data, "Hi from Client".getBytes())) {
					return true;
				}
				return false;
			}
		};
		filterListServer.add(filterServer);

		// Create Server filter
		List<ConnectableFilter> filterListClient = new ArrayList<>();
		ConnectableFilter filterClient = new ConnectableFilter() {
			@Override
			public boolean meetCriteria(byte[] data) {
				if (Arrays.equals(data, "Hi from Server".getBytes())) {
					return true;
				}
				return false;
			}
		};
		filterListClient.add(filterClient);

		RunServer s1 = new RunServer(context, 1300, filterListServer);
		RunClient c1 = new RunClient(context, 1300, filterListClient);
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(c1);
		t1.start();
		t2.start();
		Thread.sleep(3000);
		c1.setStop(true);
		s1.setStop(true);
	}

	private void Test_Server_Client_Communication(TestContext context) throws InterruptedException {
		RunServer s1 = new RunServer(context, 1200, null);
		RunClient c1 = new RunClient(context, 1200, null);
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(c1);
		t1.start();
		t2.start();
		Thread.sleep(3000);
		c1.setStop(true);
		s1.setStop(true);
	}

}

class RunClient implements Runnable {

	volatile boolean stop = false;
	TestContext context;
	List<ConnectableFilter> filterListClient = null;
	int port = 1200;

	public RunClient(TestContext context, int port, List<ConnectableFilter> filterListClient) {
		this.context = context;
		this.filterListClient = filterListClient;
		this.port = port;
	}

	@Override
	public void run() {
		try {
			TCPClient client = new TCPClient("127.0.0.1", port, filterListClient);
			client.connect();
			int j = 0;
			while (!stop) {
				client.sendMsg("Hi from Client".getBytes());
				List<Byte> expectedlist = new ArrayList<>();
				boolean keepPolling = true;
				while (keepPolling) {
					byte[] temp = client.getNextMsg(3, TimeUnit.SECONDS);
					if (null != temp) {
						for (int i = 0; i < temp.length; i++) {
							expectedlist.add(temp[i]);
						}
					}
					if (expectedlist.size() >= 14) {
						j++;
						context.getLogger().info("Client <== " + j + " " + (expectedlist.toString()));
						keepPolling = false;
						expectedlist.clear();
					}
				}
			}
			client.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

}

class RunServer implements Runnable {

	volatile boolean stop = false;
	TestContext context;
	List<ConnectableFilter> filterListServer = null;
	int port = 1200;

	public RunServer(TestContext context, int port, List<ConnectableFilter> filterListServer) {
		this.context = context;
		this.filterListServer = filterListServer;
		this.port = port;
	}

	@Override
	public void run() {
		try {
			TCPServer server = new TCPServer(port, filterListServer);
			server.connect();
			int j = 0;
			while (!stop) {
				server.sendMsg("Hi from Server".getBytes());
				List<Byte> expectedlist = new ArrayList<>();
				boolean keepPolling = true;
				while (keepPolling && !stop) {
					byte[] temp = server.getNextMsg(3, TimeUnit.SECONDS);
					if (null != temp) {
						for (int i = 0; i < temp.length; i++) {
							expectedlist.add(temp[i]);
						}
					}
					if (expectedlist.size() >= 14) {
						j++;
						context.getLogger().info("Server <== " + j + " " + (expectedlist.toString()));
						keepPolling = false;
						expectedlist.clear();
					}
				}
			}
			context.getLogger().info("Closing server");
			server.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
