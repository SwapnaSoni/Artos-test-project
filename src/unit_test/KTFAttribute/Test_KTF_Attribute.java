package unit_test.KTFAttribute;

import com.arpitos.annotation.KnownToFail;
import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "28/07/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
@KnownToFail(ktf=true, bugref="JIRA-????")
public class Test_KTF_Attribute implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Check log to ensure this test is marked as failed");
		// --------------------------------------------------------------------------------------------

	}
}
