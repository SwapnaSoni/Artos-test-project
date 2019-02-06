package com.artos.tests.groups;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@Group(group = { "123" })
@TestPlan(preparedBy = "swapna", preparationDate = "19/01/2019", bdd = "GIVEN @Group annotation is used AND test is invoked using Numeric reference string THEN test must get selected for execution")
@TestCase(skip = false, sequence = 12)
public class TEST_GROUP_NUMERIC implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is a NUMERIC GROUP 123 test");
		// --------------------------------------------------------------------------------------------

	}
}