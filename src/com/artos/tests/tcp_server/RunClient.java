package com.artos.tests.tcp_server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.artos.framework.infra.TestContext;
import com.artos.interfaces.ConnectableFilter;
import com.artos.utils.TCPClient;

public class RunClient implements Runnable {

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
			TCPClient client = new TCPClient("127.0.0.1", port, null, filterListClient);
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