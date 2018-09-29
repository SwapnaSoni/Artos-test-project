package com.artos.tests.launch_options;

import java.util.ArrayList;
import com.artos.framework.infra.Runner;
import com.artos.interfaces.PrePostRunnable;
import com.artos.interfaces.TestExecutable;

public class Main_list_empty implements PrePostRunnable {

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
	 * GIVEN User adds all available test cases (6 out of 10 in this case) to the list
	 * AND User leaves test list empty
	 * THEN All test cases present within same package (inclusive of child packages) (10 out of 10 in this case) should execute.
	 * </PRE>
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(Main_list_empty.class);
		// empty test list
		ArrayList<TestExecutable> testlist = new ArrayList<TestExecutable>();
		runner.run(args, testlist, 1);
	}

}
