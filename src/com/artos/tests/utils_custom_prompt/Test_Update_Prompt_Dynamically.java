package com.artos.tests.utils_custom_prompt;

import com.artos.annotation.TestCase;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.CustomPrompt;

@TestCase(skip = false, sequence = 0)
public class Test_Update_Prompt_Dynamically implements TestExecutable {

	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		// Countdown time blocking
		CustomPrompt cntdwn1 = new CustomPrompt(10000);
		cntdwn1.setStr1("A");
		cntdwn1.setStr2("B");
		cntdwn1.setStr3("C");
		cntdwn1.setStr4("D");
		cntdwn1.setStr5("E");
		cntdwn1.setStr6("F");
		cntdwn1.setStr7("G");
		cntdwn1.setStr8("H");
		cntdwn1.setStr9("I");
		cntdwn1.setStr10("J");
		cntdwn1.start();

		for (int i = 0; i < 100; i++) {
			cntdwn1.setStr1("A" + i);
			cntdwn1.setStr2("B" + i);
			cntdwn1.setStr3("C" + i);
			cntdwn1.setStr4("D" + i);
			cntdwn1.setStr5("E" + i);
			cntdwn1.setStr6("F" + i);
			cntdwn1.setStr7("G" + i);
			cntdwn1.setStr8("H" + i);
			cntdwn1.setStr9("I" + i);
			cntdwn1.setStr10("J" + i);
			Thread.sleep(100);
		}
		context.getLogger().debug(Boolean.toString(cntdwn1.isButtonYesPressed()) + " : " + Boolean.toString(cntdwn1.isButtonNoPressed()));
		// --------------------------------------------------------------------------------------------

	}
}
