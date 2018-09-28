package com.artos.tests.custom_prompt;

import java.util.concurrent.CountDownLatch;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.CustomPrompt;

@TestPlan(decription = "Test_Stopping_Multiple_Time", preparedBy = "arpit", preparationDate = "27/09/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Stopping_Multiple_Time implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		// Stopping count down timer object which is already stopped in blocking
		// mode.
		{
			CountDownLatch cntdwnltch = new CountDownLatch(1);
			CustomPrompt cntdwn1 = new CustomPrompt(cntdwnltch, 5000);
			cntdwn1.start();
			Thread.sleep(2000);
			cntdwn1.stop();

			// Stop second time
			cntdwn1.stop();

			cntdwnltch.await();
			// Stop again after timer is expired
			cntdwn1.stop();
		}

		// Stopping count down timer object which is already stopped in
		// non-blocking mode.
		{
			CustomPrompt cntdwn1 = new CustomPrompt(5000);
			cntdwn1.start();
			Thread.sleep(2000);
			cntdwn1.stop();

			// Stop second time
			cntdwn1.stop();
		}

		context.setTestStatus(TestStatus.PASS, "Stoping multiple time is allowed");
		// --------------------------------------------------------------------------------------------

	}
}
