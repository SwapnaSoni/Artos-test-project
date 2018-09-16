package com.artos.tests.launch_options;

import java.util.ArrayList;
import java.util.List;

import com.artos.framework.infra.Runner;
import com.artos.interfaces.PrePostRunnable;
import com.artos.interfaces.TestExecutable;

public class Main_reflection_group_CI_AUTO_SEMI implements PrePostRunnable {

	public static ArrayList<TestExecutable> getTestList() throws Exception {
		ArrayList<TestExecutable> tests = new ArrayList<TestExecutable>();

		// --------------------------------------------------------------------------------------------
		// TODO User May Add Test Case Manually as show in sample below
		// tests.add(new Test_123());
		// tests.add(new Test_abc());
		// --------------------------------------------------------------------------------------------

		return tests;
	}

	/**
	 * <PRE>
	 * GIVEN User keeps test list empty
	 * AND User wish to run all test cases belongs to "CI", "AUTO" and "SEMI" groups
	 * THEN All test cases present within same package (inclusive of child packages)
	 * AND belongs to "CI", "AUTO" and "SEMI" groups (10 out of 10 in this case) should execute.
	 * </PRE>
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(Main_reflection_group_CI_AUTO_SEMI.class);
		List<String> groupList = new ArrayList<>();
		groupList.add("CI");
		groupList.add("AUTO");
		groupList.add("SEMI");
		runner.run(args, getTestList(), 1, groupList);
	}

}
