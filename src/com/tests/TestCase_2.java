package com.tests;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.exception.InvalidDataException;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@ExpectedException(expectedExceptions = { NullPointerException.class, InvalidDataException.class }, contains = "exception example")
@TestPlan(preparedBy = "ArpitS", preparationDate = "1/1/2018", bdd = "")
@TestCase(skip = false, sequence = 0)
public class TestCase_2 implements TestExecutable {

	@Override
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		throw new NullPointerException("exception example");
		// --------------------------------------------------------------------------------------------

	}
}
