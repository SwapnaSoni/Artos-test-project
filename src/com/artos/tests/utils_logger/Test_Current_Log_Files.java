package com.artos.tests.utils_logger;

import java.io.File;
import java.util.List;

import com.artos.annotation.KnownToFail;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(description = "", preparedBy = "arpit", preparationDate = "15/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 1)
public class Test_Current_Log_Files implements TestExecutable {

	@Unit
	@KnownToFail(ktf = false)
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		List<File> logFiles = context.getLogger().getCurrentGeneralLogFiles();
		List<File> realTimelogFiles = context.getLogger().getCurrentRealTimeLogFiles();
		List<File> summarylogFiles = context.getLogger().getCurrentSummaryLogFiles();

		for (int i = 0; i < logFiles.size(); i++) {
			context.getLogger().info(logFiles.get(i));
		}
		for (int i = 0; i < realTimelogFiles.size(); i++) {
			context.getLogger().info(realTimelogFiles.get(i));
		}
		for (int i = 0; i < summarylogFiles.size(); i++) {
			context.getLogger().info(summarylogFiles.get(i));
		}
		// --------------------------------------------------------------------------------------------

	}
}
