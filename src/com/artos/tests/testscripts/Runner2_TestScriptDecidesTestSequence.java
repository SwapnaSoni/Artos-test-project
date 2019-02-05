package com.artos.tests.testscripts;

import java.util.ArrayList;
import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;
import com.artos.tests.HelperClass;

public class Runner2_TestScriptDecidesTestSequence {

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
		 * Test Script has test ordered in reverse sequence even though @testcase annotation sequence is provided, This will prove that @testcase
		 * sequence will not be considered if testscript provides sequence
		 */
		{
			String filename = "testscripts_test2.xml";
			new HelperClass().TransferFileToScriptDir("./assets/scripts/", filename);
			args = new String[] { "-t=" + filename };
			Runner runner = new Runner(Runner2_TestScriptDecidesTestSequence.class);
			runner.setTestList(getTestList());
			runner.run(args);
		}
	}

}