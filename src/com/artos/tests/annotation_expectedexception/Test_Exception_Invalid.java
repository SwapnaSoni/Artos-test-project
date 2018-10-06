package com.artos.tests.annotation_expectedexception;

import java.nio.BufferUnderflowException;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@ExpectedException(expectedExceptions = BufferUnderflowException.class, contains = "[^0-9]*[12]?[0-9]{1,2}[^0-9]*")
@TestPlan(preparedBy = "arpit", preparationDate = "28/09/2018", bdd = "GIVEN Exception is thrown AND {@code ExpectedException} is set to {@code BufferUnderflowException} THEN regardless of exception message, test should fail.")
@TestCase(skip = false, sequence = 0)
public class Test_Exception_Invalid implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		throw new Exception("299");
		// --------------------------------------------------------------------------------------------

	}
}
