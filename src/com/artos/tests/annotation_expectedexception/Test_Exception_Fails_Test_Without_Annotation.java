package com.artos.tests.annotation_expectedexception;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "28/09/2018", bdd = "GIVEN Exception is thrown AND {@code ExpectedException} is not specified THEN test should fail.")
@TestCase(skip = false, sequence = 5)
public class Test_Exception_Fails_Test_Without_Annotation implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		throw new Exception("Test Exception");
		// --------------------------------------------------------------------------------------------

	}
}
