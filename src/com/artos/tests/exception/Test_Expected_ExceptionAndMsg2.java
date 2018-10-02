package com.artos.tests.exception;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * GIVEN Exception is thrown 
 * AND {@code ExpectedException} is set to same as expected exception.
 * AND exception message matches given regular expression (Specified as string)
 * THEN test should pass.
 * </PRE>
 * 
 * @author arpit
 *
 */
@ExpectedException(expectedExceptions = Exception.class, contains = "299")
@TestPlan(decription = "Test_Expected_ExceptionAndMsg2", preparedBy = "arpit", preparationDate = "28/09/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Expected_ExceptionAndMsg2 implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		// Regular expression to match 100% text
		throw new Exception("299");
		// --------------------------------------------------------------------------------------------

	}
}
