package com.artos.tests.annotation_expectedexception;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@ExpectedException(expectedExceptions = Exception.class, contains = "[^0-9]*[12]?[0-9]{1,2}[^0-9]*")
@TestPlan(preparedBy = "arpit", preparationDate = "28/09/2018", bdd = "GIVEN Exception is thrown AND {@code ExpectedException} is set to same as expected exception AND exception message matches given regular expression THEN test should pass")
@TestCase(skip = false, sequence = 8)
public class Test_Expected_ExceptionAndMsg implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		// Regular expression to check value below 300
		throw new Exception("299");
		// --------------------------------------------------------------------------------------------

	}
}
