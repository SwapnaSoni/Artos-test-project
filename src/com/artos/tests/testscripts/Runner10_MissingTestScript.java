package com.artos.tests.testscripts;

import java.util.ArrayList;

import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;

public class Runner10_MissingTestScript {

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
		 * Test script is missing, so project should not run
		 */
		{
			String filename = "testscripts_missing.xml";
			args = new String[] { "-t=" + filename };
			Runner runner = new Runner(Runner1_TestListSpecified.class);
			runner.setTestList(getTestList());
			runner.run(args);
		}
	}

}
