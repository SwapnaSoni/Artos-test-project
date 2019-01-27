package com.tests;

import com.artos.annotation.AfterTestUnit;
import com.artos.annotation.BeforeTestUnit;
import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.exception.InvalidDataException;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;


@TestPlan(preparedBy = "ArpitS", preparationDate = "1/1/2018", bdd = "")
@TestCase(skip = false, sequence = 0)
public class TestCase_2 implements TestExecutable {

	// @Override
	// public void execute(TestContext context) throws Exception {
	// // --------------------------------------------------------------------------------------------
	// throw new NullPointerException("exception example");
	// // --------------------------------------------------------------------------------------------
	// }

	@ExpectedException(expectedExceptions = { NullPointerException.class, InvalidDataException.class }, contains = "exception example")
	@Unit
	public void unit_test(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		throw new NullPointerException("exception example");
		// --------------------------------------------------------------------------------------------
	}
	
	@BeforeTestUnit
	public void method5(TestContext context) {
		context.getLogger().debug("Before Test Unit custom T2");
	}
	
	@AfterTestUnit
	public void method6(TestContext context) {
		context.getLogger().debug("After Test Unit custom T2");
	}
}
