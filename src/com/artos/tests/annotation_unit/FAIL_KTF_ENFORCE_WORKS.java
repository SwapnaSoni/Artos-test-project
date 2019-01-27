package com.artos.tests.annotation_unit;

import com.artos.annotation.KnownToFail;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "3/01/2019", bdd = "")
@TestCase(skip = false, sequence = 9)
public class FAIL_KTF_ENFORCE_WORKS implements TestExecutable {

	@KnownToFail(ktf = true, bugref = "")
	@Unit(skip = false, sequence = 1)
	public void unit1(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.PASS, "This test unit should fail due to KTF enforcement");
		// --------------------------------------------------------------------------------------------
	}

	@KnownToFail(ktf = true, bugref = "")
	@Unit(skip = false, sequence = 2)
	public void unit2(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.KTF, "THis test unit should ktf");
		// --------------------------------------------------------------------------------------------
	}
}
