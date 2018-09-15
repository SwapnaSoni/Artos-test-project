package com.artos.tests.test_plan;

import com.artos.annotation.TestCase;
import com.artos.framework.ScanTestSuite;
import com.artos.framework.infra.LogWrapper;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * GIVEN {@code TestPlan} attribute is populated correctly
 * THEN Test Plan can be generated
 * </PRE>
 * 
 * @author arpit
 *
 */
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Generate_TestPlan_For_All implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		ScanTestSuite testPlan = new ScanTestSuite("");
		LogWrapper logger = context.getLogger();

		logger.info("\nTest Plan : ");
		logger.info(testPlan.getTestPlan(context));
		// --------------------------------------------------------------------------------------------

	}
}
