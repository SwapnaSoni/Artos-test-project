package com.artos.tests.annotation_ktf;

import com.artos.annotation.KnownToFail;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@KnownToFail(ktf = true, bugref = "JIRA-????")
@TestPlan(preparedBy = "arpit", preparationDate = "28/07/2018", bdd = "GIVEN ktf check is enforced using @KnownToFail annotation AND test outcome is not KTF THEN test will fail")
@TestCase(skip = false, sequence = 1)
public class Test_ktf_enforcement implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.PASS, "This test will fail");
		// --------------------------------------------------------------------------------------------

	}
}
