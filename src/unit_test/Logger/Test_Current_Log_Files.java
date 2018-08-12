package unit_test.Logger;

import java.io.File;
import java.util.List;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "15/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Current_Log_Files implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		List<File> logFiles = context.getLogger().getCurrentGeneralLogFiles();
		List<File> errorlogFiles = context.getLogger().getCurrentErrorLogFiles();
		List<File> summarylogFiles = context.getLogger().getCurrentSummaryLogFiles();

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
