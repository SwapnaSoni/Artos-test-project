package com.artos.tests.launch_options;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@Group(group = { "CI", "AUTO" })
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_CI_AUTO_1 implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is CI, AUTO test");
		// --------------------------------------------------------------------------------------------

	}
}
