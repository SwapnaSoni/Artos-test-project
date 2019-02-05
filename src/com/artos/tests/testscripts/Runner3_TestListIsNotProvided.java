package com.artos.tests.testscripts;

import java.util.ArrayList;
import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;
import com.artos.tests.HelperClass;

public class Runner3_TestListIsNotProvided {

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
		 * Test Script has <tests> tag but no testlist is provided, this will prove that empty test tag will pick up all test cases and use sequence
		 * listed in @testcase tag.
		 */
		{
			String filename = "testscripts_test3.xml";
			new HelperClass().TransferFileToScriptDir("./assets/scripts/", filename);
			args = new String[] { "-t=" + filename };
			Runner runner = new Runner(Runner3_TestListIsNotProvided.class);
			runner.setTestList(getTestList());
			runner.run(args);
		}
	}

}
