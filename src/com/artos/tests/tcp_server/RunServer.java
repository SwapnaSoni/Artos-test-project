package com.artos.tests.tcp_server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.artos.framework.infra.TestContext;
import com.artos.interfaces.ConnectableFilter;
import com.artos.interfaces.ConnectableMessageParser;
import com.artos.utils.TCPServer;

public class RunServer implements Runnable {

	volatile boolean stop = false;
	TestContext context;
	List<ConnectableFilter> filterListServer = null;
	ConnectableMessageParser msgParser = null;
	int port = 1200;

	public RunServer(TestContext context, int port, ConnectableMessageParser msgParser, List<ConnectableFilter> filterListServer) {
		this.context = context;
		this.filterListServer = filterListServer;
		this.msgParser = msgParser;
		this.port = port;
	}

	@Override
	public void run() {
		try {
			TCPServer server = new TCPServer(port, msgParser, filterListServer);
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
