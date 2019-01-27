package com.artos.tests.annotation_unit;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "2/01/2019", bdd = "GIVEN unit annotation is used THEN user is allowed to set unique status per test unit AND test case will take worst outcome from all units")
@TestCase(skip = false, sequence = 8)
public class FAIL_KTF_SKIP_Works implements TestExecutable {

	@Unit(sequence = 1)
	public void sequenceTest_1(TestContext context) {
		System.out.println("No sequence set 1");
		context.setTestStatus(TestStatus.FAIL, "FAIL status set");
	}

	@Unit(sequence = 2)
	public void sequenceTest_2(TestContext context) {
		System.out.println("No sequence set 2");
		context.setTestStatus(TestStatus.KTF, "KTF status set");
	}

	@Unit(sequence = 3)
	public void sequenceTest_3(TestContext context) {
		System.out.println("No sequence set 3");
		context.setTestStatus(TestStatus.SKIP, "SKIP status set");
	}

	@Unit(sequence = 4)
	public void sequenceTest_4(TestContext context) {
		System.out.println("No sequence set 4");
		context.setTestStatus(TestStatus.PASS, "PASS status set");
	}
}
