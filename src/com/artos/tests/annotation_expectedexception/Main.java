package com.artos.tests.annotation_expectedexception;

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
		tests.add(new Test_Exception_Check_Applied_If_Enforced());
		tests.add(new Test_Exception_Check_Ignored_If_Not_Enforced());
		tests.add(new Test_Exception_Fails_Test_Without_Annotation());
		tests.add(new Test_Pass_Works());
		tests.add(new Test_More_Than_one_Exception());
		tests.add(new Test_Exception_Check_Ignored_If_Skip());
		tests.add(new Test_Exception_Check_Ignored_If_KTF());
		tests.add(new Test_Exception_Msg_Using_Regex_EscapeChar());

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
