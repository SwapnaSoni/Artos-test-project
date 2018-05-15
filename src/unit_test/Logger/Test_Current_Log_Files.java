package unit_test.Logger;

import java.io.File;
import java.util.List;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "15/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Current_Log_Files implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, Test_Current_Log_Files.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "JIRA-????");
		// --------------------------------------------------------------------------------------------
		List<File> logFiles = context.getOrganiseLogger().getCurrentGeneralLogFiles();
		List<File> errorlogFiles = context.getOrganiseLogger().getCurrentErrorLogFiles();
		List<File> summarylogFiles = context.getOrganiseLogger().getCurrentSummaryLogFiles();

		for (int i = 0; i < logFiles.size(); i++) {
			context.getLogger().info(logFiles.get(i));
		}
		for (int i = 0; i < errorlogFiles.size(); i++) {
			context.getLogger().info(errorlogFiles.get(i));
		}
		for (int i = 0; i < summarylogFiles.size(); i++) {
			context.getLogger().info(summarylogFiles.get(i));
		}
		// --------------------------------------------------------------------------------------------

	}
}
