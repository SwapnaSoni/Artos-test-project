package com.tests.afterUnitGroup;

import com.artos.annotation.AfterTestUnit;
import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * - Sample test to demonstrate the use of {@code @AfterTestUnit} annotation with defining group (in lowercase)
 * - Code demonstrates that method denoted with {@code @AfterTestUnit} annotation in local scope of the test case will be executed before each test unit within the same test case if its group matches with user defined group(s)
 * </PRE>
 */
@TestPlan(preparedBy = "swapna", preparationDate = "18/01/2020", bdd = "GIVEN local after method is provided within a test case with group defined for it WHEN user defined group for After method matches with test defined After method group THEN it will get executed around each units within a test case")
@TestCase
public class AfterTestUnittest_GroupLowercase implements TestExecutable {

	@AfterTestUnit(group = { "goodpath", "FAST" })
	public void afterTestUnit(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Inside local After test unit");
		// --------------------------------------------------------------------------------------------
	}

	@Group(group = "GOODPATH")
	@Unit(sequence = 1)
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Inside testUnit_1");
		// --------------------------------------------------------------------------------------------
	}

	@Unit(sequence = 2)
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Inside testUnit_2");
		// --------------------------------------------------------------------------------------------
	}

}
