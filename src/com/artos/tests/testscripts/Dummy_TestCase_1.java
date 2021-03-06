package com.artos.tests.testscripts;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@Group(group = { "Odd" })
@TestPlan(preparedBy = "arpit", preparationDate = "5/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase(sequence = 1)
public class Dummy_TestCase_1 implements TestExecutable {

	@Unit
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.PASS, "This is dummy test case 1");
		// --------------------------------------------------------------------------------------------
	}

}
