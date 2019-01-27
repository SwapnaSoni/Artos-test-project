package com.artos.tests.utils_custom_prompt;

import java.io.File;

import com.artos.annotation.TestCase;
import com.artos.annotation.Unit;
import com.artos.framework.infra.LogWrapper;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.CustomPrompt;

/**
 * GIVEN custom prompt is exercised in non-blocking manner AND image is passed with capitalized file extension THEN custom prompt appears with the
 * given image
 *
 */
@TestCase(skip = false, sequence = 0)
public class Test_Prompt_Image implements TestExecutable {

	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------

		LogWrapper logger = context.getLogger();
		CustomPrompt cntdwn = new CustomPrompt(null, 15000);
		cntdwn.setImage(new File("./assets/images/eye2.JPEG"));
		cntdwn.setTitle("Countdown Timer : Non-Blocking");
		cntdwn.setStr2("Non-Blocking timer");
		cntdwn.start();
		Thread.sleep(10000);
		logger.debug("Yes Button Pressed : " + Boolean.toString(cntdwn.isButtonYesPressed()) + "And" + "No Button Pressed : "
				+ Boolean.toString(cntdwn.isButtonNoPressed()));

		// --------------------------------------------------------------------------------------------
	}
}
