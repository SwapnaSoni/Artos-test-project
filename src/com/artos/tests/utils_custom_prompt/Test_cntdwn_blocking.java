package com.artos.tests.utils_custom_prompt;

import java.util.concurrent.CountDownLatch;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.CustomPrompt;
import com.artos.utils.Guard;

@TestPlan(description = "\nGIVEN timer is launched with countdownlatch is set to 1\nAND time timeout is set to 5 seconds\nTHEN timer should block until timeout is achieved with an allowance of 200 msec", preparedBy = "arpit", preparationDate = "27/09/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_cntdwn_blocking implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		for (int i = 0; i < 5; i++) {
			long time = System.currentTimeMillis();

			// Count down time blocking
			CountDownLatch cntdwnltch1 = new CountDownLatch(1);
			CustomPrompt cntdwn1 = new CustomPrompt(cntdwnltch1, 5000);
			cntdwn1.setStr1("Countdown Timer : Blocking");
			cntdwn1.setStr2("" + i);
			cntdwn1.setStr3(" ");
			cntdwn1.setStr4(" ");
			cntdwn1.start();
			cntdwnltch1.await();
			cntdwn1.stop();

			long time2 = System.currentTimeMillis();

			Guard.guardEquals(context, "Event on Button Yes", false, cntdwn1.isButtonYesPressed());
			Guard.guardEquals(context, "Event on Button No", false, cntdwn1.isButtonNoPressed());
			Guard.guardEquals(context, "Timer Timeout", 5000L, (time2 - time), 200L);
		}

		context.setTestStatus(TestStatus.PASS, "Blocking method blocked thread for 5 seconds as expected with an allowable error of 200 msec");
		// --------------------------------------------------------------------------------------------

	}
}
