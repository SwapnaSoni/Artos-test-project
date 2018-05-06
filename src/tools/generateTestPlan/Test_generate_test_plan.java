package tools.generateTestPlan;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.ScanTestSuit;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "29/04/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_generate_test_plan implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, Test_generate_test_plan.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "Ticket-????");
		// --------------------------------------------------------------------------------------------
		ScanTestSuit testPlan = new ScanTestSuit("unit_test.Convert");
		testPlan.generateTestPlan(context);
		// --------------------------------------------------------------------------------------------

	}
}
