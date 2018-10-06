package com.artos.tests.utils_build_version;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Version;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(decription = "Test_BuildVersion", preparedBy = "arpit", preparationDate = "23/08/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_BuildVersion implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Build Version {}", new Version().getBuildVersion());
		context.getLogger().info("Build Date {}", new Version().getBuildDate());
		// --------------------------------------------------------------------------------------------

	}
}
