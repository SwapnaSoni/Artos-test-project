package com.artos.tests.annotation_unit;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "1/01/2019", bdd = "")
@TestCase(skip = false, sequence = 3)
public class PASS_Private_Methods_Ignored implements TestExecutable {

	@Unit()
	private void private_method_1(TestContext context) {
		System.out.println("private Method 1");
	}

	@Unit()
	private void private_method_2(TestContext context) {
		System.out.println("private Method 2");
	}

	@Unit()
	public void public_method_1(TestContext context) {
		System.out.println("public Method 1");
	}
}
