package com.tests.afterUnitGroup;

import java.util.ArrayList;

import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;
import com.google.common.collect.Lists;

public class FeatureRunner_WithSpecialCharacters {

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
		Runner runner = new Runner(FeatureRunner_WithSpecialCharacters.class);
		runner.setTestList(getTestList());
		runner.setLoopCount(1);
		
		//if single (.) is provided then regex matcher accepts it against (*) and After unit gets executed.
		runner.setTestAfterUnitGroupList(Lists.newArrayList(".."));
		runner.run(args);
	}
}
