package com.artos.tests.launch_options;

import java.util.ArrayList;
import java.util.List;

import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;

public class Main_list_group_AUTO {

	public static ArrayList<TestExecutable> getTestList() throws Exception {
		ArrayList<TestExecutable> tests = new ArrayList<TestExecutable>();

		// --------------------------------------------------------------------------------------------
		tests.add(new Test_AUTO_1());
		tests.add(new Test_AUTO_2());
		tests.add(new Test_AUTO_SEMI_1());
		tests.add(new Test_CI_1());
		tests.add(new Test_CI_2());
		tests.add(new Test_CI_AUTO_1());
		tests.add(new Test_CI_AUTO_SEMI());
		tests.add(new Test_CI_SEMI_1());
		tests.add(new Test_SEMI_1());
		tests.add(new Test_SEMI_2());
		// --------------------------------------------------------------------------------------------

		return tests;
	}

	/**
	 * <PRE>
	 * GIVEN User adds all available test cases (10 out of 10 in this case) to the list
	 * AND User wish to run all test cases belongs to "AUTO" group
	 * THEN Test cases added to the list
	 * AND belongs to "AUTO" group (5 out of 10 in this case) should execute.
	 * </PRE>
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(Main_list_group_AUTO.class);
		List<String> groupList = new ArrayList<>();
		groupList.add("AUTO");
		runner.setTestList(getTestList());
		runner.setTestGroupList(groupList);
		runner.run(args);
	}

}
