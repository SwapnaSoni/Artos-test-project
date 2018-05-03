package tools.generateTestPlan;

import com.arpitos.infra.TestContext;
import com.arpitos.infra.annotation.ScanTestSuitUsingReflection;
import com.arpitos.infra.annotation.TestPlan;
import com.arpitos.infra.annotation.TestCase;
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
		ScanTestSuitUsingReflection testPlan = new ScanTestSuitUsingReflection("unit_test.Convert");
		testPlan.generateTestPlan(context);
		// --------------------------------------------------------------------------------------------

	}
}
