package com.artos.tests.known_to_fail;

import com.artos.annotation.KnownToFail;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "28/07/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
@KnownToFail(ktf=true, bugref="JIRA-????")
public class Test_KTF_Attribute implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Check log to ensure this test is marked as failed");
		// --------------------------------------------------------------------------------------------

	}
}
