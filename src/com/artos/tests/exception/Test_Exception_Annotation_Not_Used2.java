package com.artos.tests.exception;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * GIVEN {@code ExpectedException} is not specified
 * AND test does not fail or throw an exception.
 * THEN test should pass.
 * </PRE>
 * 
 * @author arpit
 *
 */
@TestPlan(decription = "Test_Exception_Annotation_Not_Used2", preparedBy = "arpit", preparationDate = "28/09/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Exception_Annotation_Not_Used2 implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.PASS, "No Exception Annotation");
		// --------------------------------------------------------------------------------------------

	}
}
