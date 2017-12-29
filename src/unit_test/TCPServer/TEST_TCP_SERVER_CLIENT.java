package unit_test.TCPServer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.arpitos.framework.TEST;
import com.arpitos.infra.TestContext;
import com.arpitos.interfaces.TestExecutor;
import com.arpitos.utils.TCPClient;
import com.arpitos.utils.TCPServer;

/***
 * 
 * <PRE>
 * START_OF_TEST_HEADER
 * TEST_TARGET			= 	TEST_TCP_SERVER_CLIENT
 * TEST_STEPS			=	???
 * EXPECTED_RESULTS		=	???
 * DEPENDENCY			=	None
 * NOTES				=	None
 * PREPARED_BY			=	arpit_000
 * REVIEWED_BY			=	
 * REVIEW_DATE			=	dd/mm/yyyy
 * END_OF_TEST_HEADER
 * </PRE>
 */
public class TEST_TCP_SERVER_CLIENT extends TEST implements TestExecutor {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, TEST_TCP_SERVER_CLIENT.class, "arpit_000", "26/09/2016", "");
	}

	protected void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "");

		// --------------------------------------------------------------------------------------------
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				runServer(context);
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				runClient(context);
			}
		});
		t1.start();
		t2.start();
		Thread.sleep(3000);
		// --------------------------------------------------------------------------------------------

	}

	private void runClient(TestContext context) {
		try {
			TCPClient client = new TCPClient("127.0.0.1", 1200);
			client.connect();
			boolean continueRun = true;
			while (continueRun) {
				client.sendData("Hi from Client");
				List<Byte> expectedlist = new ArrayList<>();
				boolean keepPolling = true;
				while (keepPolling) {
					byte[] temp = client.getNextMSG(5, TimeUnit.SECONDS);
					if (null != temp) {
						for (int i = 0; i < temp.length; i++) {
							expectedlist.add(temp[i]);
						}
					}
					if (expectedlist.size() >= 14) {
						context.getLogger().info("Client <== " + (expectedlist.toString()));
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

	private void runServer(TestContext context) {
		try {
			TCPServer server = new TCPServer(1200);
			server.connect();
			boolean continueRun = true;
			while (continueRun) {
				server.sendData("Hi from Server");
				List<Byte> expectedlist = new ArrayList<>();
				boolean keepPolling = true;
				while (keepPolling) {
					byte[] temp = server.getNextMSG(5, TimeUnit.SECONDS);
					if (null != temp) {
						for (int i = 0; i < temp.length; i++) {
							expectedlist.add(temp[i]);
						}
					}
					if (expectedlist.size() >= 14) {
						context.getLogger().info("Serer <== " + (expectedlist.toString()));
						keepPolling = false;
						expectedlist.clear();
					}
				}

			}
			server.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}