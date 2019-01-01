package com.artos.tests.utils_custom_prompt;

import java.io.File;
import java.util.concurrent.CountDownLatch;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.LogWrapper;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.CustomPrompt;

@TestPlan(preparedBy = "arpit", preparationDate = "15/10/2018", bdd = "GIVEN larger than 700 wide image is provided THEN timer bar auto adjust the size")
@TestCase(skip = false, sequence = 0)
public class Test_Image_Size implements TestExecutable {

	@Override
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		long starttime = System.currentTimeMillis();
		LogWrapper logger = context.getLogger();
		CountDownLatch contdwn = new CountDownLatch(1);
		CustomPrompt cntdwn = new CustomPrompt(contdwn, 10000);
		cntdwn.setImage(new File("./assets/images/1024x1024.jpg"));
		cntdwn.setTitle("Countdown Timer : Blocking");
		cntdwn.setStr2("Blocking timer");
		cntdwn.start();
		contdwn.await();
		logger.debug("Yes Button Pressed : " + Boolean.toString(cntdwn.isButtonYesPressed()) + "And" + "No Button Pressed : "
				+ Boolean.toString(cntdwn.isButtonNoPressed()));
		System.err.println(System.currentTimeMillis() - starttime);
		
		starttime = System.currentTimeMillis();
		contdwn = new CountDownLatch(1);
		cntdwn = new CustomPrompt(contdwn, 15000);
		cntdwn.setImage(new File("./assets/images/1024x768.jpg"));
		cntdwn.setTitle("Countdown Timer : Blocking");
		cntdwn.start();
		contdwn.await();
		logger.debug("Yes Button Pressed : " + Boolean.toString(cntdwn.isButtonYesPressed()) + "And" + "No Button Pressed : "
				+ Boolean.toString(cntdwn.isButtonNoPressed()));
		System.err.println(System.currentTimeMillis() - starttime);
		// --------------------------------------------------------------------------------------------

	}
}
