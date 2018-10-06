package com.artos.tests.utils_transform;

import java.util.ArrayList;

import com.artos.annotation.AfterTest;
import com.artos.annotation.AfterTestSuite;
import com.artos.annotation.BeforeTest;
import com.artos.annotation.BeforeTestSuite;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.Runner;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.PrePostRunnable;
import com.artos.interfaces.TestExecutable;

public class Main implements PrePostRunnable {

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
		Runner runner = new Runner(Main.class);
		runner.run(args, getTestList(), 1);
	}

	@BeforeTestSuite
	public void beforeTestSuite(TestContext context) throws Exception {
		System.err.println("before test suite");
		context.setTestStatus(TestStatus.PASS, "Before Test Suite");
	}

	@AfterTestSuite
	public void afterTestSuite(TestContext context) throws Exception {
		System.err.println("after test suite");
		context.setTestStatus(TestStatus.PASS, "After Test Suite");
	}

	@BeforeTest
	public void beforeTest(TestContext context) throws Exception {
		System.err.println("before test");
		context.setTestStatus(TestStatus.PASS, "Before Test");
	}

	@AfterTest
	public void afterTest(TestContext context) throws Exception {
		System.err.println("after test");
		context.setTestStatus(TestStatus.PASS, "After Test");
	}
}
