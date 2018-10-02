package com.artos.tests.exception;

import java.util.ArrayList;
import com.artos.framework.infra.Runner;
import com.artos.interfaces.PrePostRunnable;
import com.artos.interfaces.TestExecutable;

public class Main implements PrePostRunnable {

	public static ArrayList<TestExecutable> getTestList() throws Exception {
		ArrayList<TestExecutable> tests = new ArrayList<TestExecutable>();

		// --------------------------------------------------------------------------------------------
		
		// Good path
		tests.add(new Test_Expected_Exception());
		tests.add(new Test_Expected_ExceptionAndMsg());
		tests.add(new Test_Expected_ExceptionAndMsg2());
		tests.add(new Test_Fail_Before_valid_Exception());
		tests.add(new Test_Enforce_Exception_Checking());
		tests.add(new Test_Enforce_Exception_Checking2());
		tests.add(new Test_Exception_Annotation_Not_Used());
		tests.add(new Test_Exception_Annotation_Not_Used2());
		tests.add(new Test_More_Than_one_Exception());
		
		// Bad path
		tests.add(new Test_Exception_Invalid());
		tests.add(new Test_RegEx_Value_Invalid());
		tests.add(new Test_More_Than_one_Exception2());
		
		// --------------------------------------------------------------------------------------------

		return tests;
	}

	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(Main.class);
		runner.run(args, getTestList(), 1);
	}

}
