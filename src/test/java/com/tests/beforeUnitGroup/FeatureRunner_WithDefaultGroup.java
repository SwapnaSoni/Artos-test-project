package com.tests.beforeUnitGroup;

import java.util.ArrayList;

import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;
import com.google.common.collect.Lists;

public class FeatureRunner_WithDefaultGroup {

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
		Runner runner = new Runner(FeatureRunner_WithDefaultGroup.class);
		runner.setTestList(getTestList());
		runner.setLoopCount(1);
		runner.setTestBeforeUnitGroupList(Lists.newArrayList("*"));
		runner.run(args);
	}
}
