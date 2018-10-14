package com.artos.tests.utils_udpconnector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.ConnectableFilter;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Transform;
import com.artos.utils.UDP;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "7/07/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_UDP_Connector implements TestExecutable {

	@Override public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		// Launch UDP server with filter in separate thread
		Thread t = new Thread(new UDPTest(context));
		t.start();

		// Launch UDP server with no filter
		UDP server2 = new UDP("127.0.0.1", 2345, "127.0.0.1", 1234);
		server2.connect();
		Transform _tfm = new Transform();
		
		
		while (true) {
			server2.sendMsg(_tfm.strHexToByteArray("31 32 33 34"));
			Thread.sleep(100);
			server2.sendMsg(_tfm.strHexToByteArray("32 31 31 31"));
			Thread.sleep(100);
		}

		// ===> User should only see "32 31 31 31" printed because first msg
		// should
		// be filtered
		// --------------------------------------------------------------------------------------------

	}
}

class UDPTest implements Runnable {

	TestContext context;

	public UDPTest(TestContext context) {
		this.context = context;
	}

	@Override
	public void run() {
		try {
			// Add filter
			List<ConnectableFilter> filterList = new ArrayList<>();
			ConnectableFilter filter1 = new ConnectableFilter() {
				@Override
				public boolean meetCriteria(byte[] data) {
					if (data[0] == (byte) 0x31) {
						return true;
					}
					return false;
				}
			};
			filterList.add(filter1);

			// Launch UDP server
			UDP server1 = new UDP("127.0.0.1", 1234, "127.0.0.1", 2345, filterList);
			server1.connect();
			Transform _tfm = new Transform();
			while (true) {
				byte[] data = server1.getNextMsg(2000, TimeUnit.MILLISECONDS);
				if (null != data) {
					context.getLogger().info(_tfm.bytesToHexString(data));
					server1.sendMsg("Hello How Are you");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
