package com.artos.tests.groups;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@Group(group = { "CI", "SEMI" })
@TestCase(skip = false, sequence = 8)
public class Test_CI_SEMI_1 implements TestExecutable {

	@Override public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is CI, SEMI test");
		// --------------------------------------------------------------------------------------------

	}
}
