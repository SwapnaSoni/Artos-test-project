package unit_test.TCPServer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.TCPClient;
import com.arpitos.utils.TCPServer;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "3/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_tcp_server_client implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, Test_tcp_server_client.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "JIRA-????");
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
				server.sendMsg("Hi from Server");
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