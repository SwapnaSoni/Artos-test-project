package com.artos.tests.annotation_dataprovider;

import java.util.ArrayList;
import com.artos.framework.infra.Runner;
import com.artos.interfaces.PrePostRunnable;
import com.artos.interfaces.TestExecutable;

public class Main implements PrePostRunnable {

	public static ArrayList<TestExecutable> getTestList() throws Exception {
		ArrayList<TestExecutable> tests = new ArrayList<TestExecutable>();

		// --------------------------------------------------------------------------------------------
		// Good path
		tests.add(new Test_NonDataProvider());
		tests.add(new Test_Static_DataProvider());
		tests.add(new Test_NonStatic_DataProvider());
		tests.add(new Test_DataProvider_Ignore_Case());

		// Bad path
		tests.add(new Test_Invalid_DataProvider_Name());
		tests.add(new Test_DataProvider_Wrong_Casting());
		tests.add(new Test_Single_Dimention_DataProvider());
		tests.add(new Test_EmptyDataProvider());
		tests.add(new Test_Null_DataProvider());
		// --------------------------------------------------------------------------------------------

		return tests;
	}

	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(Main.class);
		runner.run(args, getTestList(), 1);
	}

}
