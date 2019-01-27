package com.artos.tests.launch_options;

import java.util.ArrayList;

import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;

public class Main_testscript_list_all_group_all {

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
	 * GIVEN user has supplied test script via command line
	 * AND user wish to run test cases belong to "*" group
	 * AND test script has all test cases listed
	 * THEN listed test cases which belongs to "*" group (10 out of 10 in this case) should execute
	 * </PRE>
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		args = new String[1];
		args[0] = "--testscript=./assets/scripts/launch_options_list_all_group_all.xml";
		Runner runner = new Runner(Main_testscript_list_all_group_all.class);
		runner.setTestList(getTestList()); runner.run(args);
	}

}
