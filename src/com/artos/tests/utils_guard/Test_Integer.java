package com.artos.tests.utils_guard;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;

@TestPlan(description = "", preparedBy = "arpit", preparationDate = "13/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_Integer implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		Guard.guardEquals(context, "Test isEqual() works", true, Guard.isEquals(123, 123));
		Guard.guardEquals(context, "Test isEqual() works", true, Guard.isEquals(Integer.MAX_VALUE, Integer.MAX_VALUE));
		Guard.guardEquals(context, "Test isEqual() works", true, Guard.isEquals(Integer.MIN_VALUE, Integer.MIN_VALUE));
		Guard.guardEquals(context, "Test isEqual() works", false, Guard.isEquals(12345, 12347));

		Guard.guardEquals(context, "Test guardEquals() works", 99999, 99999);
		Guard.guardEquals(context, "Test guardEquals() works", Integer.MAX_VALUE, Integer.MAX_VALUE);
		Guard.guardEquals(context, "Test guardEquals() works", Integer.MIN_VALUE, Integer.MIN_VALUE);
		try {
			Guard.guardEquals(context, "Test guardEquals() works", 9999, 9990);
			Guard.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guard.guardEquals(context, e, "Test guardEquals() works values are not equal");
		}

		Guard.guardEquals(context, "Test guardEquals() works", Integer.MAX_VALUE - 2, Integer.MAX_VALUE, 5);
		Guard.guardEquals(context, "Test guardEquals() works", Integer.MIN_VALUE + 1, Integer.MIN_VALUE, 5);
		try {
			Guard.guardEquals(context, "Test guardEquals() works", 999999, 999990, 2);
			Guard.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guard.guardEquals(context, e, "Test guardEquals() works values are not equal");
		}

		Guard.guardNotEquals(context, "Test guardEquals() works", 123456, 345678);
		Guard.guardNotEquals(context, "Test guardEquals() works", Integer.MAX_VALUE, Integer.MIN_VALUE);
		try {
			Guard.guardNotEquals(context, "Test guardEquals() works", 1239999, 1239999);
			Guard.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guard.guardEquals(context, e, "Test guardEquals() works values are equal");
		}
		// --------------------------------------------------------------------------------------------

	}
}
