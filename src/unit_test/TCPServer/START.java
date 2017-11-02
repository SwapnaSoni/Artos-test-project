package unit_test.TCPServer;

import com.arpit.framework.Start;
import com.arpit.infra.TestContext;
import com.arpit.interfaces.TestExecutor;

public class START implements TestExecutor {

	public void onExecute(TestContext context) throws Exception {
		Start s = new Start();
		s.onExecute(context, START.class, "arpit_000", "18/09/2016", "");
	}
}