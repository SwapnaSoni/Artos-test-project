package com.artos.tests.annotation_expectedexception;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@ExpectedException(expectedExceptions = { Exception.class }, contains = "Test (123)")
@TestPlan(description = "", preparedBy = "arpit", preparationDate = "1/10/2018", bdd = "GIVEN exception message is specified AND exception description has character which can be confused as regex escape characters THEN test should pass by matching description using normal string compare")
@TestCase(skip = false, sequence = 12)
public class Test_Exception_Msg_Using_Regex_EscapeChar implements TestExecutable {

	@Override
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		// Test (123) where brackets can be misunderstood as regex escape char so string matching will be used instead. 
		throw new Exception("Test (123)");
		// --------------------------------------------------------------------------------------------

	}
}
