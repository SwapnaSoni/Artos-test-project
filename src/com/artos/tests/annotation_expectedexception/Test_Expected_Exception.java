package com.artos.tests.annotation_expectedexception;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@ExpectedException(expectedExceptions = Exception.class)
@TestPlan(decription = "Test_Expected_Exception", preparedBy = "arpit", preparationDate = "28/09/2018", bdd = "GIVEN Exception is thrown AND {@code ExpectedException} is set to same as expected exception THEN test should pass")
@TestCase(skip = false, sequence = 7)
public class Test_Expected_Exception implements TestExecutable {

	@Override public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		throw new Exception("Hello How are you");
		// --------------------------------------------------------------------------------------------

	}
}
