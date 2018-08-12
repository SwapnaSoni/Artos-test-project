package unit_test.Tree;

import java.io.File;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Tree;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "12/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Tree implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info(Tree.printDirectoryTree(new File(".")));
		// --------------------------------------------------------------------------------------------

	}
}
