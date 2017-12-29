package unit_test.Zip;

import com.arpitos.framework.START;
import com.arpitos.infra.TestContext;
import com.arpitos.interfaces.TestExecutor;

public class Start implements TestExecutor {

	public void onExecute(TestContext context) throws Exception {
		START s = new START();
		s.onExecute(context, Start.class, "arpit", "30/12/2017", "");
	}
}