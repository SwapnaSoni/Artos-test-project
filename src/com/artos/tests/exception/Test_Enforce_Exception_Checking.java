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
 * AND exception checking is enforced (enforce = true)
 * AND test case does not throw an exception
 * THEN test should fail.
 * </PRE>
 * 
 * @author arpit
 *
 */
@ExpectedException(expectedExceptions = Exception.class, contains = "299", enforce = true)
@TestPlan(preparedBy = "arpit", preparationDate = "28/09/2018", bdd = "GIVEN {@code ExpectedException} is set AND exception checking is enforced (enforce = true) AND test case does not throw an exception THEN test should fail.")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Enforce_Exception_Checking implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.PASS, "Did not throw acception even through exception annotation was specified");
		// --------------------------------------------------------------------------------------------

	}
}
