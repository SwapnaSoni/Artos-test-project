package com.artos.tests.groups;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@Group(group = { "Manual", "AutO" })
@TestPlan(preparedBy = "swapna", preparationDate = "19/01/2019", bdd = "GIVEN @Group annotation is used AND test is invoked using Alphabetic string THEN test must get selected for execution")
@TestCase(skip = false, sequence = 13)
public class TEST_MANUAL implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is a manual, Auto test");
		// --------------------------------------------------------------------------------------------

	}
}
