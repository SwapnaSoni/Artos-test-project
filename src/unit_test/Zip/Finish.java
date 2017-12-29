package unit_test.Zip;

import com.arpitos.framework.FINISH;
import com.arpitos.infra.TestContext;
import com.arpitos.interfaces.TestExecutor;

public class Finish implements TestExecutor {

	public void onExecute(TestContext context) throws Exception {
		FINISH f = new FINISH();
		f.onExecute(context, Finish.class, "arpit", "30/12/2017", "");
	}
}