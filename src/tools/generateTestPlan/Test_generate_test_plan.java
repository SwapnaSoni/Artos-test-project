package tools.generateTestPlan;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.ScanTestSuite;
import com.artos.framework.infra.LogWrapper;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@Group(group={"G6_SKT_TAL", "G7_SKT_TAL", "AB\uabcC ", "OPTQ\nABCD/\\"})
@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "20/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_generate_test_plan implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		ScanTestSuite testPlan = new ScanTestSuite("unit_test.Convert");
		LogWrapper logger = context.getLogger();

		logger.info("\nTest Plan : ");
		logger.info(testPlan.getTestPlan(context));
		// --------------------------------------------------------------------------------------------

	}
}
