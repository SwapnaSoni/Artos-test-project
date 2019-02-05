package com.artos.tests.testscripts;

import java.util.ArrayList;
import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;
import com.artos.tests.HelperClass;

public class Runner6_LoopCountDefault {

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
		/*
		 * Test Script has no loop count is specified and user will see all test cases in GUI test selector. this will prove that by default loop
		 * count is 1
		 */
		{
			String filename = "testscripts_test6.xml";
			new HelperClass().TransferFileToScriptDir("./assets/scripts/", filename);
			args = new String[] { "-t=" + filename };
			Runner runner = new Runner(Runner4_TestCaseGroupNoGroupSpecified.class);
			runner.setTestList(getTestList());
			runner.run(args);
		}
	}

}
