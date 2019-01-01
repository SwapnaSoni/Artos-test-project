package com.artos.tests.utils_custom_prompt;

import java.util.concurrent.CountDownLatch;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.CustomPrompt;
import com.artos.utils.Guard;

@TestPlan(description = "Test_ReInitialising_Object", preparedBy = "arpit", preparationDate = "27/09/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_ReInitialising_Object implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		// Re-Initialise count down timer object which is already launched in
		// blocking mode.
		try {
			CountDownLatch cntdwnltch = new CountDownLatch(1);
			CustomPrompt cntdwn1 = new CustomPrompt(cntdwnltch, 5000);
			cntdwn1.start();

			// reinitialise
			cntdwn1.start();

			Thread.sleep(3000);
			cntdwnltch.await();
			cntdwn1.stop();

			Guard.guardWrongFlow("Expected exception : The window is showing on screen");
		} catch (Exception e) {
			if (e.getMessage().contains("The window is showing on screen")) {
				context.getLogger().debug("Exception as expected" + e.getMessage());
			} else {
				throw e;
			}
		}

		// Re-Initialise count down timer object which is already launched in
		// non-blocking mode.
		try {
			CustomPrompt cntdwn1 = new CustomPrompt(5000);
			cntdwn1.start();

			// reinitialise
			cntdwn1.start();

			Thread.sleep(3000);
			cntdwn1.stop();

			Guard.guardWrongFlow("Expected exception : The window is showing on screen");
		} catch (Exception e) {
			if (e.getMessage().contains("The window is showing on screen")) {
				context.getLogger().debug("Exception as expected" + e.getMessage());
			} else {
				throw e;
			}
		}

		context.setTestStatus(TestStatus.PASS, "Re-Initialisation of object is not allowed");
		// --------------------------------------------------------------------------------------------

	}
}
