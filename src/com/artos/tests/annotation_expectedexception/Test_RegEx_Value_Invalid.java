package com.artos.tests.annotation_expectedexception;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@ExpectedException(expectedExceptions = Exception.class, contains = "[^0-9]*[12]?[0-9]{1,2}[^0-9]*")
@TestPlan(description = "Test_RegEx_Value_Invalid", preparedBy = "arpit", preparationDate = "28/09/2018", bdd = "GIVEN Exception is thrown AND {@code ExpectedException} is set to same as expected exception AND exception message does not match given regular expression THEN test should fail.")
@TestCase(skip = false, sequence = 14)
public class Test_RegEx_Value_Invalid implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		// Regular expression to check value below 300
		throw new Exception("400");
		// --------------------------------------------------------------------------------------------

	}
}
