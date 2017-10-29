package unittest;

import com.arpit.framework.Finish;
import com.arpit.infra.TestContext;
import com.arpit.interfaces.TestExecutor;

public class FINISH implements TestExecutor {

	public void onExecute(TestContext context) throws Exception {
		Finish f = new Finish();
		f.onExecute(context, FINISH.class, "arpit_000", "18/09/2016", "");
	}
}
