package com.artos.tests.utils_tcp_server;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * GIVEN Server and Client are configured using same port
 * AND they both make connection
 * THEN user will see serer and client request and response printed on console
 * </PRE>
 * 
 * @author arpit
 *
 */
@TestPlan(description = "", preparedBy = "arpit", preparationDate = "3/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_Server_Client_Communication implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		RunServer s1 = new RunServer(context, 1200, null, null);
		RunClient c1 = new RunClient(context, 1200, null);
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(c1);
		t1.start();
		t2.start();
		Thread.sleep(3000);
		c1.setStop(true);
		s1.setStop(true);
		context.setTestStatus(TestStatus.PASS, "Server Client Comms working");
		// --------------------------------------------------------------------------------------------

	}
}
