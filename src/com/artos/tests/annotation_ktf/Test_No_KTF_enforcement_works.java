package com.artos.tests.annotation_ktf;

import com.artos.annotation.KnownToFail;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "6/10/2018", bdd = "GIVEN KTF checking is not enforced via @KnownToFail annotation AND user sets test status to KTF THEN test outcome will be KTF")
@TestCase(skip = false, sequence = 6)
public class Test_No_KTF_enforcement_works implements TestExecutable {

	@KnownToFail(ktf = false, bugref = "JIRA-????")
	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.PASS, "This test will be KTF");
		context.setTestStatus(TestStatus.KTF, "This test will be KTF");
		// --------------------------------------------------------------------------------------------

	}
}
