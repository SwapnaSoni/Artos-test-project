package com.artos.tests.testscripts;

import java.util.ArrayList;
import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;
import com.artos.tests.HelperClass;

public class Runner4_TestCaseGroupNoGroupSpecified {

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
		 * Test Script has <tests> tag but no testlist is provided, Testscript does not specify any group so all test cases will be visible in GUI
		 * test selector. This proves that by default all test cases will be taken
		 */
		{
			String filename = "testscripts_test4.xml";
			new HelperClass().TransferFileToScriptDir("./assets/scripts/", filename);
			args = new String[] { "-t=" + filename };
			Runner runner = new Runner(Runner4_TestCaseGroupNoGroupSpecified.class);
			runner.setTestList(getTestList());
			runner.run(args);
		}
	}

}