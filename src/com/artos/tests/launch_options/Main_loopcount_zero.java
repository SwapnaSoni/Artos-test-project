package com.artos.tests.launch_options;

import java.util.ArrayList;

import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;

public class Main_loopcount_zero {

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
	 * Given loop count is set to zero
	 * THEN test should execute 1 time
	 * </PRE>
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(Main_loopcount_zero.class);
		runner.setTestList(getTestList());
		runner.setLoopCount(0);
		runner.run(args);
	}

}
