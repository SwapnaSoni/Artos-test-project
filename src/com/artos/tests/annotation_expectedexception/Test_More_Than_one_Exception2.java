package com.artos.tests.annotation_expectedexception;

import java.nio.BufferUnderflowException;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(description = "", preparedBy = "arpit", preparationDate = "1/10/2018", bdd = "GIVEN more than one exceptions are specified AND description matching is provided AND test case throws exception which does not match any of the exception but matches description THEN test case fails")
@TestCase(skip = false, sequence = 12)
public class Test_More_Than_one_Exception2 implements TestExecutable {

	@ExpectedException(expectedExceptions = { BufferUnderflowException.class, NumberFormatException.class, NullPointerException.class }, contains = "abc")
	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		throw new Exception("abc");
		// --------------------------------------------------------------------------------------------

	}
}
