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
@TestPlan(preparedBy = "arpit", preparationDate = "18/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase
public class Test_TestUnit_Importance implements TestExecutable {

	@TestImportance(Importance.CRITICAL)
	@Unit(sequence = 1)
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.FAIL, "This is CRITICAL importance test case");
		// --------------------------------------------------------------------------------------------
	}
	
	@TestImportance(Importance.LOW)
	@Unit(sequence = 2)
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.FAIL, "This is LOW importance test case");
		// --------------------------------------------------------------------------------------------
	}
	
	
	@TestImportance(Importance.MEDIUM)
	@Unit(sequence = 3)
	public void testUnit_3(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.FAIL, "This is MEDIUM importance test case");
		// --------------------------------------------------------------------------------------------
	}

}
