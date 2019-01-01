package com.artos.tests.groups;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@Group(group = { "SEMI" })
@TestCase(skip = false, sequence = 10)
public class Test_SEMI_2 implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is SEMI test");
		// --------------------------------------------------------------------------------------------

	}
}
