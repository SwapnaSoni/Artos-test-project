package com.artos.tests.groups;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@Group(group = { "AUTO", "SEMI" })
@TestCase(skip = false, sequence = 3)
public class Test_AUTO_SEMI_1 implements TestExecutable {

	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is AUTO, SEMI test");
		// --------------------------------------------------------------------------------------------

	}
}
