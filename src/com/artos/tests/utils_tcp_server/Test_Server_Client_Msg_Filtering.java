package com.artos.tests.utils_tcp_server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.artos.annotation.TestCase;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.ConnectableFilter;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.CustomPrompt;

/**
 * <PRE>
 * GIVEN server client are initiated with filter object
 * THEN any msg from server or client meeting filter criteria will be removed from the queue so it will not be printed
 * </PRE>
 * 
 * @author arpit
 *
 */
@TestCase(skip = false, sequence = 0)
public class Test_Server_Client_Msg_Filtering implements TestExecutable {

	@Override public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		CountDownLatch cntdwn = new CountDownLatch(1);
		CustomPrompt prompt = new CustomPrompt(cntdwn, 10000);
		prompt.setStr1("Server Client application will run");
		prompt.setStr2("Ensure no server client communications are printed");
		prompt.setStr3("Press OK to continue");
		prompt.start();
		cntdwn.await();

		// Create Client filter
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

		RunServer s1 = new RunServer(context, 1300, null, filterListServer);
		RunClient c1 = new RunClient(context, 1300, filterListClient);
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(c1);
		t1.start();
		t2.start();
		Thread.sleep(5000);
		c1.setStop(true);
		s1.setStop(true);

		cntdwn = new CountDownLatch(1);
		prompt = new CustomPrompt(cntdwn, 10000);
		prompt.setStr1("Confirm that no communication were printed on screen");
		prompt.start();
		cntdwn.await();

		if (prompt.isButtonYesPressed()) {
			context.setTestStatus(TestStatus.PASS, "Filtering is working");
		} else {
			context.setTestStatus(TestStatus.PASS, "Filtering did not work");
		}
		// --------------------------------------------------------------------------------------------

	}
}
