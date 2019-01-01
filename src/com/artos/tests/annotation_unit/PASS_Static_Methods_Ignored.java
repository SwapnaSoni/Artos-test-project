package com.artos.tests.annotation_unit;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "1/01/2019", bdd = "GIVEN unit annotation is used on static method THEN static methods are ignored")
@TestCase(skip = false, sequence = 2)
public class PASS_Static_Methods_Ignored implements TestExecutable {

	@Unit()
	public static void static_method_1(TestContext context) {
		System.out.println("Static Method 1");
	}

	@Unit()
	public static void static_method_2(TestContext context) {
		System.out.println("Static Method 2");
	}

	@Unit()
	public void non_static_method_1(TestContext context) {
		System.out.println("Non Static Method 1");
	}
}
