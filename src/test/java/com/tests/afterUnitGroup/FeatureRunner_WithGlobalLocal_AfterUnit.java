package com.tests.afterUnitGroup;

import java.util.ArrayList;

import com.artos.annotation.AfterTestUnit;
import com.artos.annotation.BeforeTestUnit;
import com.artos.framework.infra.Runner;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.google.common.collect.Lists;

public class FeatureRunner_WithGlobalLocal_AfterUnit {

	public static ArrayList<TestExecutable> getTestList() throws Exception {
		ArrayList<TestExecutable> tests = new ArrayList<TestExecutable>();

		// --------------------------------------------------------------------------------------------
		// TODO User May Add Test Case Manually as show in sample below
		// tests.add(new Test_123());
		// tests.add(new Test_abc());
		// --------------------------------------------------------------------------------------------

		return tests;
	}

	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(FeatureRunner_WithGlobalLocal_AfterUnit.class);
		runner.setTestList(getTestList());
		runner.setLoopCount(1);
		runner.setTestAfterUnitGroupList(Lists.newArrayList("*"));
		runner.setTestUnitGroupList(Lists.newArrayList("GOODPATH", "BADPATH"));
		runner.run(args);
	}
	
	@BeforeTestUnit
	public void globalBeforeTestUnit(TestContext context) throws Exception {
		context.getLogger().info("Inside global Before test unit");
	}

	@AfterTestUnit
	public void globalAfterTestUnit(TestContext context) throws Exception {
		context.getLogger().info("Inside global After test unit");
	}

}
