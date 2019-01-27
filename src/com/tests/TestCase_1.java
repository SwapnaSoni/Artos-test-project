package com.tests;

import com.artos.annotation.AfterTestUnit;
import com.artos.annotation.BeforeTestUnit;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "1/1/2018", bdd = "given test project is set correctly and logger is used to log HELLO WORLD string then hello world should be printed correctly")
@TestCase(skip = false, sequence = 0)
public class TestCase_1 implements TestExecutable {

	// @Override
	// public void execute(TestContext context) throws Exception {
	// // --------------------------------------------------------------------------------------------
	// context.getLogger().debug("Hello World");
	// // --------------------------------------------------------------------------------------------
	// }

	@Unit
	public void unit_test(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().debug("Hello World");
		// --------------------------------------------------------------------------------------------

	}
	
	@BeforeTestUnit
	public void method5(TestContext context) {
		context.getLogger().debug("Before Test Unit custom T1");
	}
	
	@AfterTestUnit
	public void method6(TestContext context) {
		context.getLogger().debug("After Test Unit custom T1");
	}
}
