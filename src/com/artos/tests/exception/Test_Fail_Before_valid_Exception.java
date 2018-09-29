package com.artos.tests.exception;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * GIVEN Test status is set to fail before exception is thrown
 * AND {@code ExpectedException} is set to same as expected exception.
 * AND exception message matches given regular expression
 * THEN test should fail.
 * </PRE>
 * 
 * @author arpit
 *
 */
@ExpectedException(expectedException = Exception.class, contains = "299")
@TestPlan(decription = "Test_Fail_Before_valid_Exception", preparedBy = "arpit", preparationDate = "28/09/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Fail_Before_valid_Exception implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.FAIL, "Fail before exception is thrown");
		// Regular expression to match 100% text
		throw new Exception("299");
		// --------------------------------------------------------------------------------------------

	}
}