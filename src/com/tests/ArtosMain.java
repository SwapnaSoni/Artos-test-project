package com.tests;

import com.artos.annotation.AfterTest;
import com.artos.annotation.AfterTestSuite;
import com.artos.annotation.AfterTestUnit;
import com.artos.annotation.BeforeTest;
import com.artos.annotation.BeforeTestSuite;
import com.artos.annotation.BeforeTestUnit;
import com.artos.framework.infra.Runner;
import com.artos.framework.infra.TestContext;

public class ArtosMain {

	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(ArtosMain.class);
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
	
	@BeforeTestUnit
	public void method5(TestContext context) {
		context.getLogger().debug("Before Test Unit");
	}
	
	@AfterTestUnit
	public void method6(TestContext context) {
		context.getLogger().debug("After Test Unit");
	}
}
