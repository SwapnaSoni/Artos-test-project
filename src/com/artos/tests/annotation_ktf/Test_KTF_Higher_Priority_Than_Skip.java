package com.artos.tests.annotation_ktf;

import com.artos.annotation.KnownToFail;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@KnownToFail(ktf = false, bugref = "JIRA-????")
@TestPlan(preparedBy = "arpit", preparationDate = "6/10/2018", bdd = "GIVEN KTF is atleast set once during test execution AND rest of the time test is set with SKIP status THEN test outcome will be KTF")
@TestCase(skip = false, sequence = 4)
public class Test_KTF_Higher_Priority_Than_Skip implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.KTF, "This test will be KTF");
		context.setTestStatus(TestStatus.SKIP, "This test will be KTF");
		// --------------------------------------------------------------------------------------------

	}
}