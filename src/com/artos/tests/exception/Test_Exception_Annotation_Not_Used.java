package com.artos.tests.exception;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * GIVEN Exception is thrown 
 * AND {@code ExpectedException} is not specified
 * THEN test should fail.
 * </PRE>
 * 
 * @author arpit
 *
 */
@TestPlan(decription = "Test_Exception_Annotation_Not_Used", preparedBy = "arpit", preparationDate = "28/09/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Exception_Annotation_Not_Used implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		throw new Exception("Test Exception");
		// --------------------------------------------------------------------------------------------

	}
}
