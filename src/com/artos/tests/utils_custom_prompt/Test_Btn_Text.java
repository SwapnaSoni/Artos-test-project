package com.artos.tests.utils_custom_prompt;

import java.util.concurrent.CountDownLatch;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.CustomPrompt;

@TestPlan(description = "Test_Btn_Text", preparedBy = "arpit", preparationDate = "27/09/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_Btn_Text implements TestExecutable {

	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		String[] text = new String[] { "????", "****", "####", "Yes", "No", "True", "False", "12345678901234567890", "!@#$%^&*()" };

		for (int i = 0; i < text.length; i++) {
			CountDownLatch cntdwnltch = new CountDownLatch(1);
			CustomPrompt cntdwn2 = new CustomPrompt(cntdwnltch, 2000);
			cntdwn2.setBtnYesText(text[i]);
			cntdwn2.setBtnNoText(text[i]);
			cntdwn2.setStr1("Button Text");
			cntdwn2.setStr2(" ");
			cntdwn2.setStr3(" ");
			cntdwn2.setStr4(" ");

			cntdwn2.start();
			cntdwnltch.await();
		}
		context.setTestStatus(TestStatus.PASS, "Button can accept various text, longer text are truncated");
		// --------------------------------------------------------------------------------------------

	}
}
