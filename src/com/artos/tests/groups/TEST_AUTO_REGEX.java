package com.artos.tests.groups;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@Group(group = { "Test" })
@TestPlan(preparedBy = "swapna", preparationDate = "19/01/2019", bdd = "GIVEN @Group annotation is used AND test is invoked using Regex string THEN test must get selected for execution")
@TestCase(skip = false, sequence = 11)
public class TEST_AUTO_REGEX implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is a Auto REGEX test");
		// --------------------------------------------------------------------------------------------

	}
}
