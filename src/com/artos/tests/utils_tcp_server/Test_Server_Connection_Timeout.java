package com.artos.tests.utils_tcp_server;

import java.net.SocketTimeoutException;

import com.artos.annotation.TestCase;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;
import com.artos.utils.TCPServer;

/**
 * <PRE>
 * GIVEN Server is initialised with SO timeout
 * AND Client does not make connection within given timeout
 * THEN Server should shut down and exit.
 * </PRE>
 * 
 * @author arpit
 *
 */
@TestCase(skip = false, sequence = 0)
public class Test_Server_Connection_Timeout implements TestExecutable {

	@Override public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		// Check if user initialise server with fix socket timeout and no client
		// connects within that timeout then socket timeout exception should be
		// thrown
		try {
			TCPServer server = new TCPServer(1400);
			server.connect(2000);

			// It should timeout in absence of client
			Guard.guardWrongFlow("Server should have timed out in absence of client");
		} catch (SocketTimeoutException e) {
			// Do nothing if socket timeout exception occured
			context.getLogger().info("Exception is as expected");
			context.setTestStatus(TestStatus.PASS, "Server timeout is working");
		}
		// --------------------------------------------------------------------------------------------

	}
}
