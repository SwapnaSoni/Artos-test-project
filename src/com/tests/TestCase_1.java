package com.tests;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "2/12/2018", bdd = "given test project is set correctly and logger is used to log HELLO WORLD string then hello world should be printed correctly")
@TestCase(skip = false, sequence = 0)
public class TestCase_1 implements TestExecutable {

	@Override
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		System.out.println("Hello World");
		context.getLogger().debug("Hello World");
		// --------------------------------------------------------------------------------------------

	}
}
