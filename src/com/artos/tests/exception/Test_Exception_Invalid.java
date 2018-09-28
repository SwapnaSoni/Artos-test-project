package com.artos.tests.exception;

import java.nio.BufferUnderflowException;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * GIVEN Exception is thrown 
 * AND {@code ExpectedException} is set to {@code BufferUnderflowException}
 * THEN regardless of exception message, test should fail.
 * </PRE>
 * 
 * @author arpit
 *
 */
@ExpectedException(expectedException = BufferUnderflowException.class, contains = "[^0-9]*[12]?[0-9]{1,2}[^0-9]*")
@TestPlan(decription = "Test_Exception_Invalid", preparedBy = "arpit", preparationDate = "28/09/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Exception_Invalid implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		throw new Exception("299");
		// --------------------------------------------------------------------------------------------

	}
}
