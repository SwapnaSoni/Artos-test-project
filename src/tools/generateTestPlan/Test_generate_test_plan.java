package tools.generateTestPlan;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.ScanTestSuite;
import com.arpitos.framework.infra.LogWrapper;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "20/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_generate_test_plan implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "JIRA-????");
		// --------------------------------------------------------------------------------------------
		ScanTestSuite testPlan = new ScanTestSuite("unit_test.Convert");
		LogWrapper logger = context.getLogger();

		logger.info("\nTest Plan : ");
		logger.info(testPlan.getTestPlan(context));

		logger.info("\nTest Labels : ");
		logger.info(testPlan.getTestLabelsToPrint(context));
		// --------------------------------------------------------------------------------------------

	}
}
