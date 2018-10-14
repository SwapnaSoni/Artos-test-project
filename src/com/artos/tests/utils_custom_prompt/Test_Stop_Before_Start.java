package com.artos.tests.utils_custom_prompt;

import java.util.concurrent.CountDownLatch;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.CustomPrompt;

@TestPlan(decription = "Test_Stop_Before_Start", preparedBy = "arpit", preparationDate = "27/09/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_Stop_Before_Start implements TestExecutable {

	@Override public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		// Stopping count down timer before object start in blocking mode.
		{
			CountDownLatch cntdwnltch = new CountDownLatch(1);
			CustomPrompt cntdwn1 = new CustomPrompt(cntdwnltch, 5000);

			// Stop before start
			cntdwn1.stop();

			cntdwn1.start();

			Thread.sleep(2000);
			cntdwn1.stop();
		}

		// Stopping count down timer before object start in non-blocking mode.
		{
			CustomPrompt cntdwn1 = new CustomPrompt(5000);

			// Stop before start
			cntdwn1.stop();

			cntdwn1.start();
			Thread.sleep(2000);
			cntdwn1.stop();
		}

		context.setTestStatus(TestStatus.PASS, "Stop before start does not interrupt the flow");
		// --------------------------------------------------------------------------------------------

	}
}
