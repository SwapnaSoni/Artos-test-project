package tools.generateTestPlan;

import com.arpitos.infra.TestContext;
import com.arpitos.infra.annotation.GenerateTestPlan;
import com.arpitos.infra.annotation.Testcase;
import com.arpitos.interfaces.TestExecutable;


// @formatter:off
@Testcase(skip=false, scenario = "Test_generate_test_plan",
decription = "\nGIVEN : "
           + "\nAND   : "
           + "\nWHEN  : "
           + "\nAND   : "
           + "\nTHEN  : "
, preparedBy = "arpit", preparationDate = "8/04/2018", reviewedBy = "", reviewDate = "")
// @formatter:on
public class Test_generate_test_plan implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, Test_generate_test_plan.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "");
		//--------------------------------------------------------------------------------------------
		GenerateTestPlan testPlan = new GenerateTestPlan(context, "unit_test");
		//--------------------------------------------------------------------------------------------

	}
}