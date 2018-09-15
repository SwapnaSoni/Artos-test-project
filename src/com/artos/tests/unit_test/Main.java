package com.artos.tests.unit_test;

import java.util.ArrayList;

import com.artos.framework.infra.Runner;
import com.artos.interfaces.PrePostRunnable;
import com.artos.interfaces.TestExecutable;

public class Main implements PrePostRunnable {

	public static ArrayList<TestExecutable> getTestList() throws Exception {
		ArrayList<TestExecutable> tests = new ArrayList<TestExecutable>();

		// --------------------------------------------------------------------------------------------
		// TODO User May Add Test Case Manually as show in sample below
		// tests.add(new Test_123());
		// tests.add(new Test_abc());
		tests.addAll(com.artos.tests.transform.Main.getTestList());
		tests.addAll(com.artos.tests.custom_prompt.Main.getTestList());
		tests.addAll(com.artos.tests.guard.Main.getTestList());
		tests.addAll(com.artos.tests.properties_file_reader.Main.getTestList());
		tests.addAll(com.artos.tests.tree.Main.getTestList());
		tests.addAll(com.artos.tests.utils_string.Main.getTestList());
		tests.addAll(com.artos.tests.ziptar.Main.getTestList());
		// --------------------------------------------------------------------------------------------

		return tests;
	}

	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(Main.class);
		runner.run(args, getTestList(), 1);
	}

}
