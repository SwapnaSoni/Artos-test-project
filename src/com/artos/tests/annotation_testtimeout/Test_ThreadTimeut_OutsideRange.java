package com.artos.tests.annotation_testtimeout;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "4/11/2018", bdd = "")
@TestCase(skip = false, sequence = 0, testtimeout = 5000)
public class Test_ThreadTimeut_OutsideRange implements TestExecutable {

	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		Thread.sleep(5100);
		// --------------------------------------------------------------------------------------------

	}
}
