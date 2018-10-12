package com.artos.tests.annotation_expectedexception;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "28/09/2018", bdd = "GIVEN {@code ExpectedException} is not specified AND test does not fail or throw an exception THEN test should pass")
@TestCase(skip = false, sequence = 13)
public class Test_Pass_Works implements TestExecutable{

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.PASS, "No Exception Annotation");
		// --------------------------------------------------------------------------------------------

	}
}
