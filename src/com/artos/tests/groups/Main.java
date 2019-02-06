package com.artos.tests.groups;

import java.util.ArrayList;
import java.util.List;

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
        // TODO User May Add Test Case Manually as show in sample below
        // tests.add(new Test_123());
        // tests.add(new Test_abc());
		// --------------------------------------------------------------------------------------------

		return tests;
	}

	public static void main(String[] args) throws Exception {

		Runner runner = new Runner(Main.class);
		List<String> groupList = new ArrayList<String>();
//		groupList.add("(Test)");
//		groupList.add("Manual");
//		groupList.add("auto");
//		groupList.add("123");
//		groupList.add("aUto");
//		groupList.add("AUTO");
//		groupList.add("^(A).*"); // anything that starts with A
//		groupList.add(".*o$"); // anything that ends with o
//		groupList.add("1.*"); // starting with numeric 1
//		groupList.add("[^0-9]"); // any number seq
//		groupList.add("^A.*"); // starting with caps A
//		groupList.add("([Aa-Zz][Aa-Zz][Aa-Zz][Aa-Zz]).*"); // any first 4 characters
//		groupList.add("([0-9]).*"); // starting with any number
//		groupList.add("^.*"); // starting with any char (covers special characters as well)
//		groupList.add("\\$.*"); // anything starting with $
		groupList.add("*"); // all tests
		runner.setTestGroupList(groupList);
		runner.setTestList(getTestList());
		runner.run(args);

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
