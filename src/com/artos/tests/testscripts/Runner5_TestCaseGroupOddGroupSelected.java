package com.artos.tests.testscripts;

import java.util.ArrayList;
import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;
import com.artos.tests.HelperClass;

public class Runner5_TestCaseGroupOddGroupSelected {

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
		 * Test Script has <tests> tag but no testlist is provided, Testscript specifies "Odd" group for test cases, so only odd test cases will
		 * appear in GUI test selector.
		 */
		{
			String filename = "testscripts_test5.xml";
			new HelperClass().TransferFileToScriptDir("./assets/scripts/", filename);
			args = new String[] { "-t=" + filename };
			Runner runner = new Runner(Runner5_TestCaseGroupOddGroupSelected.class);
			runner.setTestList(getTestList());
			runner.run(args);
		}
	}

}