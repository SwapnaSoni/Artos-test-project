package com.artos.tests.groups;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@Group(group = { "$#$#" })
@TestPlan(preparedBy = "swapna", preparationDate = "26/01/2019", bdd = "GIVEN @Group annotation is used AND test is invoked using either Regex string "
		+ "(having special characters or using special character string THEN test must get selected for execution")
@TestCase(skip = false, sequence = 14)
public class TEST_SPECIAL_CHAR implements TestExecutable {

		public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is a $#$# REGEX test");
		// --------------------------------------------------------------------------------------------

	}
}
