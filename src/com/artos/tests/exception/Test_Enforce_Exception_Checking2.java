package com.artos.tests.exception;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * GIVEN {@code ExpectedException} is set
 * AND exception checking is not enforced (enforce = false)
 * AND test case does not throw an exception
 * THEN test should pass.
 * </PRE>
 * 
 * @author arpit
 *
 */
@ExpectedException(expectedExceptions = Exception.class, contains = "299", enforce = false)
@TestPlan(decription = "Test_Pass_When_Exception_Is_Specified", preparedBy = "arpit", preparationDate = "28/09/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Enforce_Exception_Checking2 implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.PASS, "Did not throw acception even through exception annotation was specified");
		// --------------------------------------------------------------------------------------------

	}
}
