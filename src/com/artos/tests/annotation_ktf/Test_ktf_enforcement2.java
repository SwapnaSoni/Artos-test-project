package com.artos.tests.annotation_ktf;

import com.artos.annotation.KnownToFail;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "6/10/2018", bdd = "GIVEN ktf check is enforced using @KnownToFail annotation AND test status is KTF THEN test outcome will be KTF")
@TestCase(skip = false, sequence = 2)
public class Test_ktf_enforcement2 implements TestExecutable {

	@Unit
	@KnownToFail
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.PASS, "This test will be KTF");
		context.setTestStatus(TestStatus.KTF, "This test will be KTF");
		// --------------------------------------------------------------------------------------------

	}
}
