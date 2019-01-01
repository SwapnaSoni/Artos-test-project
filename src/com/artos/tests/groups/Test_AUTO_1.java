package com.artos.tests.groups;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@Group(group = { "AUTO" })
@TestCase(skip = false, sequence = 1)
public class Test_AUTO_1 implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is AUTO test");
		// --------------------------------------------------------------------------------------------

	}
}
