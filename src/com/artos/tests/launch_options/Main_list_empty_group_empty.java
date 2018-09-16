package com.artos.tests.launch_options;

import java.util.ArrayList;
import java.util.List;

import com.artos.framework.infra.Runner;
import com.artos.interfaces.PrePostRunnable;
import com.artos.interfaces.TestExecutable;

public class Main_list_empty_group_empty implements PrePostRunnable {

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
	 * GIVEN User leaves testlist = empty and grouplist = empty
	 * THEN All test cases present within same package (inclusive of child packages) (10 out of 10 in this case) should execute.
	 * </PRE>
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(Main_list_empty_group_empty.class);
		ArrayList<TestExecutable> testsList = new ArrayList<TestExecutable>();
		List<String> groupList = new ArrayList<>();
		runner.run(args, testsList, 1, groupList);
	}

}
