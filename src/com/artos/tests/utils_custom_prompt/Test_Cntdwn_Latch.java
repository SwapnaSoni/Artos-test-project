package com.artos.tests.utils_custom_prompt;

import java.util.concurrent.CountDownLatch;

import com.artos.annotation.TestCase;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.CustomPrompt;
import com.artos.utils.Guard;

/**
 * <PRE>
 * GIVEN Countdown latch is launched with counter more than 1
 * AND custom prompt is called with countdown latch and countdown latch await is exercised
 * THEN when countdown timer expires, custom prompt must get closed and test must proceed as normal
 * </PRE>
 * 
 */
@TestCase(skip = false, sequence = 0)
public class Test_Cntdwn_Latch implements TestExecutable {

	public void execute(TestContext context) throws Exception, InterruptedException {

		// --------------------------------------------------------------------------------------------
		//Blocking Countdown Latch
		CountDownLatch cntdwnltch = new CountDownLatch(2);
		CustomPrompt cntdwn1 = new CustomPrompt(cntdwnltch, 15000);
		cntdwn1.setBtnYesText("YES");
		cntdwn1.setBtnNoText("NO");
		cntdwn1.setTitle("Blocking Latch Test");
		cntdwn1.start();
		cntdwnltch.await();
		context.setTestStatus(TestStatus.PASS, "Blocking Successful");
		
		//Unblocking Countdown Latch
		CustomPrompt cntdwn2 = new CustomPrompt(null, 15000);
		cntdwn2.setTitle("Unblocking Latch Test");
		cntdwn2.setBtnYesText("YES");
		cntdwn2.setBtnNoText("NO");
		cntdwn2.setStr1("Click on YES button now.");
		cntdwn2.start();
		Thread.sleep(10000);
		context.setTestStatus(TestStatus.PASS, "Unblocking Successful");
		Guard.guardEquals(context, "", cntdwn2.isButtonYesPressed(), true);
		// --------------------------------------------------------------------------------------------
	}
}
