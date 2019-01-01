package com.artos.tests.annotation_expectedexception;

import java.nio.BufferUnderflowException;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@ExpectedException(expectedExceptions = { BufferUnderflowException.class, NumberFormatException.class, NullPointerException.class }, contains = "abc")
@TestPlan(description = "", preparedBy = "arpit", preparationDate = "1/10/2018", bdd = "GIVEN more than one exceptions are specified AND description matching is provided AND test case throws exception which matches one of the exception and description THEN test case passes")
@TestCase(skip = false, sequence = 11)
public class Test_More_Than_one_Exception implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		throw new NullPointerException("abc");
		// --------------------------------------------------------------------------------------------

	}
}
