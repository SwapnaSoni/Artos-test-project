package com.artos.tests.annotation_unit;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "1/01/2019", bdd = "GIVEN unit annotation is used along with expectedException THEN expectedException works as expected")
@TestCase(skip = false, sequence = 7)
public class PASS_Expected_Exception_Works implements TestExecutable {

	@Unit(sequence = 1)
	@ExpectedException(expectedExceptions = Exception.class, contains = "299", enforce = true)
	public void testexception_Enforced_1(TestContext context) throws Exception {
		System.out.println("Test Exception is enforced and test throws expected exception");
		throw new Exception("299");
	}

	@Unit(sequence = 2, skip = true)
	@ExpectedException(expectedExceptions = Exception.class, contains = "299", enforce = false)
	public void test_Execution_GoodPath_2(TestContext context) {
		System.out.println("SKIP test exception does not fail the test.");
	}

	@Unit(sequence = 3)
	@ExpectedException(expectedExceptions = Exception.class, contains = "299", enforce = false)
	public void test_Execution_GoodPath_3(TestContext context) {
		System.out.println("test exception does not fail if exception check is not enforced.");
	}
}
