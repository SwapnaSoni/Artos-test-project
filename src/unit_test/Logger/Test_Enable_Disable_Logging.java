package unit_test.Logger;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "15/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Enable_Disable_Logging implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "JIRA-????");
		// --------------------------------------------------------------------------------------------
		// log enabled by default
		for (int i = 0; i < 10; i++) {
			context.getLogger().info(i);
		}

		// log should stop printing
		context.getLogger().disableGeneralLog();
		for (int i = 11; i < 20; i++) {
			context.getLogger().info(i);
		}

		// log should be enabled again
		context.getLogger().enableGeneralLog();
		for (int i = 21; i < 30; i++) {
			context.getLogger().info(i);
		}
		// --------------------------------------------------------------------------------------------

	}
}
