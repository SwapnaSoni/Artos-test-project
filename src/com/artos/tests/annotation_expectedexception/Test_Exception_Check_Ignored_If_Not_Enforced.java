package com.artos.tests.annotation_expectedexception;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "28/09/2018", bdd = "GIVEN {@code ExpectedException} is set AND exception checking is not enforced (enforce = false) AND test case does not throw an exception THEN test should pass")
@TestCase(skip = false, sequence = 3)
public class Test_Exception_Check_Ignored_If_Not_Enforced implements TestExecutable {

	@ExpectedException(expectedExceptions = Exception.class, contains = "299", enforce = false)
	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.PASS, "Did not throw acception even through exception annotation was specified");
		// --------------------------------------------------------------------------------------------

	}
}
