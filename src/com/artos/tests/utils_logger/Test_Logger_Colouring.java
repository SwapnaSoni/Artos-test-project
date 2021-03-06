package com.artos.tests.utils_logger;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(description = "Test_Logger_Colouring", preparedBy = "arpit", preparationDate = "23/08/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 3)
public class Test_Logger_Colouring implements TestExecutable {

	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Hiiii This is info");
		context.getLogger().debug("Hiiii This is debug");
		context.getLogger().fatal("Hiiii This is fatal");
		context.getLogger().warn("Hiiii This is warning");
		context.getLogger().error("Hiiii This is error");
		// --------------------------------------------------------------------------------------------

	}
}
