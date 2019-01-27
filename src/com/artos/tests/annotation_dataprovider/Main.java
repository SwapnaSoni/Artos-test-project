package com.artos.tests.annotation_dataprovider;

import java.util.ArrayList;

import com.artos.annotation.AfterTest;
import com.artos.annotation.AfterTestSuite;
import com.artos.annotation.BeforeTest;
import com.artos.annotation.BeforeTestSuite;
import com.artos.framework.infra.Runner;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

public class Main {

	public static ArrayList<TestExecutable> getTestList() throws Exception {
		ArrayList<TestExecutable> tests = new ArrayList<TestExecutable>();

		// --------------------------------------------------------------------------------------------
		// --------------------------------------------------------------------------------------------

		return tests;
	}

	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(Main.class);
		runner.setTestList(getTestList()); runner.run(args);
	}

	@BeforeTestSuite
	public void method1(TestContext context) {
		context.getLogger().debug("Before Test Suite");
	}

	@AfterTestSuite
	public void method2(TestContext context) {
		context.getLogger().debug("After Test Suite");
	}

	@BeforeTest
	public void method3(TestContext context) {
		context.getLogger().debug("Before Test");
	}

	@AfterTest
	public void method4(TestContext context) {
		context.getLogger().debug("After Test");
	}

}
