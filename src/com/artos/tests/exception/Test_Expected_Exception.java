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
 * THEN test should pass.
 * </PRE>
 * 
 * @author arpit
 *
 */
@ExpectedException(expectedException = Exception.class)
@TestPlan(decription = "Test_Expected_Exception", preparedBy = "arpit", preparationDate = "28/09/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Expected_Exception implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		throw new Exception("Hello How are you");
		// --------------------------------------------------------------------------------------------

	}
}
