package com.artos.tests.launch_options;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@Group(group = { "CI", "SEMI" })
@TestCase(skip = false, sequence = 8)
public class Test_CI_SEMI_1 implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is CI, SEMI test");
		// --------------------------------------------------------------------------------------------

	}
}
