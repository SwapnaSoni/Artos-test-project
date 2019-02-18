package com.artos.tests.annotation_testimportance;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestImportance;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.Importance;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestImportance(Importance.CRITICAL)
@TestPlan(preparedBy = "Arpit", preparationDate = "01/01/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase
public class Test_TestCase_Importance implements TestExecutable {

	@Unit
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.PASS, "do something");
		// --------------------------------------------------------------------------------------------
	}

	@Unit
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.SKIP, "do something");
		// --------------------------------------------------------------------------------------------
	}

	@Unit
	public void testUnit_3(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.KTF, "do something");
		// --------------------------------------------------------------------------------------------
	}

	@Unit
	public void testUnit_4(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.FAIL, "do something");
		// --------------------------------------------------------------------------------------------
	}

}
