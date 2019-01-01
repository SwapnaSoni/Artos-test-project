package com.artos.tests.annotation_unit;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "24/12/2018", bdd = "GIVEN unit annotation is used AND sequence number is not provided for one or more methods THEN unit test order of execution can not be guarnteed")
@TestCase(skip = false, sequence = 0)
public class PASS_Unit_No_Sequence_No implements TestExecutable {

	@Unit
	public void sequenceTest_1(TestContext context) {
		System.out.println("No sequence set 1");
	}

	@Unit
	public void sequenceTest_2(TestContext context) {
		System.out.println("No sequence set 2");
	}

	@Unit
	public void sequenceTest_3(TestContext context) {
		System.out.println("No sequence set 3");
	}
}
