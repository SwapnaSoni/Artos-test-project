package com.artos.tests.launch_options;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@Group(group = { "AUTO" })
@TestCase(skip = false, sequence = 2)
public class Test_AUTO_2 implements TestExecutable {

	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is AUTO test");
		// --------------------------------------------------------------------------------------------

	}
}
