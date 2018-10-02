package com.artos.tests.test_plan;

import java.util.List;

import com.artos.annotation.TestCase;
import com.artos.framework.ScanTestSuite;
import com.artos.framework.TestPlanWrapper;
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
		List<TestPlanWrapper> testPlanObjectList = testPlan.getTestPlan(context);
		for (TestPlanWrapper testPlanObject : testPlanObjectList) {
			StringBuilder sb = new StringBuilder();
			sb.append("\n\nTestCaseName : " + testPlanObject.getTestCaseName());
			sb.append("\nDescription : " + testPlanObject.getTestDescription());
			sb.append("\nPreparedBy : " + testPlanObject.getTestPreparedBy());
			sb.append("\nPreparationDate : " + testPlanObject.getTestPreparationDate());
			sb.append("\nReviewedBy : " + testPlanObject.getTestReviewedBy());
			sb.append("\nReviewedDate : " + testPlanObject.getTestReviewedDate());
			sb.append("\nBDD Test Plan : " + testPlanObject.getTestBDD());
			System.out.println(sb.toString());
		}
		// --------------------------------------------------------------------------------------------

	}
}
