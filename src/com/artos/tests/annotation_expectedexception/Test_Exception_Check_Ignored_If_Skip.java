package com.artos.tests.annotation_expectedexception;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "6/10/2018", bdd = "GIVEN {@code ExpectedException} annotation is specified AND Test is marked as skip by user THEN test outcome should be skip AND it should not fail with exception checking")
@TestCase(skip = false, sequence = 4)
public class Test_Exception_Check_Ignored_If_Skip implements TestExecutable {

	@ExpectedException(expectedExceptions = { NullPointerException.class })
	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.SKIP, "User choose to skip the test case");
		// --------------------------------------------------------------------------------------------

	}
}
