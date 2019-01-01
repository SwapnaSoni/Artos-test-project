package com.artos.tests.annotation_unit;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "1/01/2019", bdd = "GIVEN unit annotation is used and Skip attribute is enabled THEN unit will be skipped from execution list")
@TestCase(skip = false, sequence = 4)
public class PASS_Skip_Methods_Ignored implements TestExecutable {

	@Unit(sequence = 0, skip = true)
	public void skip_enabled_1(TestContext context) {
		System.out.println("SKIP enabled");
	}

	@Unit(sequence = 1)
	public void skip_disabled_1(TestContext context) {
		System.out.println("skip disabled 1");
	}

	@Unit(sequence = 2)
	public void skip_disabled_2(TestContext context) {
		System.out.println("skip disable 2");
	}
}
