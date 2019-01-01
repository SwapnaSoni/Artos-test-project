package com.artos.tests.annotation_unit;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "1/01/2019", bdd = "GIVEN unit annotation is used and test timeout is set then if test takes longer than provided timeout THEN unit is marked as fail")
@TestCase(skip = false, sequence = 5)
public class FAIL_TestTimeout_Works implements TestExecutable {

	@Unit(sequence = 1, testtimeout = 5000)
	public void testTimeout_BadPath_1(TestContext context) throws Exception {
		System.out.println("Test timeout of 5 seconds");
		Thread.sleep(5010);
	}

	@Unit(sequence = 2, testtimeout = 5000)
	public void testTimeout_GoodPath_1(TestContext context) throws Exception {
		System.out.println("Test timeout of 5 seconds, good path");
		Thread.sleep(3000);
	}

	@Unit(sequence = 3, testtimeout = 5000)
	public void testTimeout_GoodPath_2(TestContext context) throws Exception {
		System.out.println("Test timeout of 5 seconds, good path");
		Thread.sleep(4500);
	}

	@Unit(sequence = 3, testtimeout = 0)
	public void testTimeout_GoodPath_3(TestContext context) throws Exception {
		System.out.println("Test timeout of 0 seconds which means no timeout, good path");
		Thread.sleep(4500);
	}
}
