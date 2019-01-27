package com.artos.tests.annotation_expectedexception;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "28/09/2018", bdd = "GIVEN Test status is set to fail before exception is thrown AND {@code ExpectedException} is set to same as expected exception AND exception message matches given regular expression THEN test should fail.")
@TestCase(skip = false, sequence = 10)
public class Test_Fail_Before_valid_Exception implements TestExecutable {

	@ExpectedException(expectedExceptions = Exception.class, contains = "299")
	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.FAIL, "Fail before exception is thrown");
		// Regular expression to match 100% text
		throw new Exception("299");
		// --------------------------------------------------------------------------------------------

	}
}
