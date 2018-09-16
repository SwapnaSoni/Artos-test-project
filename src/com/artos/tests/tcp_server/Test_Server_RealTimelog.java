package com.artos.tests.tcp_server;

import java.util.concurrent.TimeUnit;

import com.artos.annotation.TestCase;
import com.artos.framework.infra.TestContext;
import com.artos.framework.listener.RealTimeLogEventListener;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.TCPClient;
import com.artos.utils.TCPServer;
import com.artos.utils.Transform;

@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Server_RealTimelog implements TestExecutable {

	TCPServer server;

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		Transform _transform = new Transform();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					server = new TCPServer(1300);
					RealTimeLogEventListener realTimeListener = new RealTimeLogEventListener(context);
					server.setRealTimeListener(realTimeListener);
					server.connect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();

		TCPClient client = new TCPClient("127.0.0.1", 1300);
		client.connect();

		for (int i = 0; i < 100; i++) {
			client.sendMsg(("Hi I am Client " + i).getBytes());
			context.getLogger().info(_transform.bytesToHexString(server.getNextMsg(1000, TimeUnit.MILLISECONDS), true));
			server.sendMsg(("Hi I am Server " + i).getBytes());
			context.getLogger().info(_transform.bytesToHexString(client.getNextMsg(1000, TimeUnit.MILLISECONDS), true));
		}

		// --------------------------------------------------------------------------------------------

	}
}
