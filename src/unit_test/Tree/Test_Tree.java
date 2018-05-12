package unit_test.Tree;

import java.io.File;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Tree;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "12/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Tree implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, Test_Tree.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "JIRA-????");
		// --------------------------------------------------------------------------------------------
		context.getLogger().info(Tree.printDirectoryTree(new File(".")));
		// --------------------------------------------------------------------------------------------

	}
}
