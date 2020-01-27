package com.tests.beforeUnitGroup;

import com.artos.annotation.BeforeTestUnit;
import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * - Sample test to demonstrate the use of {@code @BeforeTestUnit} annotation with defining group (in lowercase)
 * - Code demonstrates that method denoted with {@code @BeforeTestUnit} annotation in local scope of the test case will be executed before each test unit within the same test case if its group matches with user defined group(s)
 * </PRE>
 */
@TestPlan(preparedBy = "swapna", preparationDate = "18/01/2020", bdd = "GIVEN local before method is provided within a test case with group defined for it WHEN user defined group for Before method matches with test defined Before method group THEN it will get executed around each units within a test case")
@TestCase
public class BeforeTestUnittest_GroupLowercase implements TestExecutable {

	@BeforeTestUnit(group = { "goodpath", "FAST" })
	public void beforeTestUnit(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Inside local Before test unit");
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
