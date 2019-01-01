package com.artos.tests.annotation_unit;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "1/01/2019", bdd = "GIVEN unit annotation is used AND timeout is specified at Test case level AND timeout is specified at Test unit level AND Testcase timeout before Testunit THEN TestCase failure is handlled correctly")
@TestCase(skip = false, sequence = 6, testtimeout = 5000)
public class FAIL_TestCase_Timeout_Before_TestUnit implements TestExecutable {

	@Unit(sequence = 1, testtimeout = 6000)
	public void testTimeout_BadPath_1(TestContext context) throws Exception {
		System.out.println("Test timeout of 5 seconds");
		Thread.sleep(6010);
	}
}
