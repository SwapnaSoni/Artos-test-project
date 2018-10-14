package com.artos.tests.annotation_ktf;

import com.artos.annotation.KnownToFail;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@KnownToFail(ktf = true, bugref = "JIRA-????")
@TestPlan(preparedBy = "arpit", preparationDate = "6/10/2018", bdd = "GIVEN ktf check is enforced using @KnownToFail annotation AND test status is KTF THEN test outcome will be KTF")
@TestCase(skip = false, sequence = 2)
public class Test_ktf_enforcement2 implements TestExecutable {

	@Override public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.PASS, "This test will be KTF");
		context.setTestStatus(TestStatus.KTF, "This test will be KTF");
		// --------------------------------------------------------------------------------------------

	}
}
