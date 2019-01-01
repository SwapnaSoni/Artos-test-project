package com.artos.tests.annotation_ktf;

import com.artos.annotation.KnownToFail;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@KnownToFail(ktf = false, bugref = "JIRA-????")
@TestPlan(preparedBy = "arpit", preparationDate = "6/10/2018", bdd = "GIVEN FAIL is atleast set once during test execution AND rest of the time test is set with KTF status THEN test outcome will be FAIL")
@TestCase(skip = false, sequence = 5)
public class Test_KTF_Lower_Priority_Than_Fail implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.FAIL, "This test will be KTF");
		context.setTestStatus(TestStatus.KTF, "This test will be KTF");
		// --------------------------------------------------------------------------------------------

	}
}