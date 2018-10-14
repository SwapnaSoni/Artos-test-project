package com.artos.tests.utils_logger;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "15/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 2)
public class Test_Enable_Disable_Logging implements TestExecutable {

	@Override public void execute(TestContext context, Object data1, Object data2) throws Exception {

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
