package com.artos.tests.utils_guard;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;

@TestPlan(description = "", preparedBy = "arpit", preparationDate = "13/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_Long implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		Guard.guardEquals(context, "Test isEqual() works", true, Guard.isEquals(123l, 123));
		Guard.guardEquals(context, "Test isEqual() works", true, Guard.isEquals(Long.MAX_VALUE, Long.MAX_VALUE));
		Guard.guardEquals(context, "Test isEqual() works", true, Guard.isEquals(Long.MIN_VALUE, Long.MIN_VALUE));
		Guard.guardEquals(context, "Test isEqual() works", false, Guard.isEquals(123456789l, 123456788l));

		Guard.guardEquals(context, "Test guardEquals() works", 9999999999l, 9999999999l);
		Guard.guardEquals(context, "Test guardEquals() works", Long.MAX_VALUE, Long.MAX_VALUE);
		Guard.guardEquals(context, "Test guardEquals() works", Long.MIN_VALUE, Long.MIN_VALUE);
		try {
			Guard.guardEquals(context, "Test guardEquals() works", 9999999999l, 9999999998l);
			Guard.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guard.guardEquals(context, e, "Test guardEquals() works values are not equal");
		}

		Guard.guardEquals(context, "Test guardEquals() works", Long.MAX_VALUE - 2, Long.MAX_VALUE, 5);
		Guard.guardEquals(context, "Test guardEquals() works", Long.MIN_VALUE + 1, Long.MIN_VALUE, 5);
		try {
			Guard.guardEquals(context, "Test guardEquals() works", 999999l, 999990l, 2);
			Guard.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guard.guardEquals(context, e, "Test guardEquals() works values are not equal");
		}

		Guard.guardNotEquals(context, "Test guardEquals() works", 123456l, 345678l);
		Guard.guardNotEquals(context, "Test guardEquals() works", Long.MAX_VALUE, Long.MIN_VALUE);
		try {
			Guard.guardNotEquals(context, "Test guardEquals() works", 1239999l, 1239999l);
			Guard.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guard.guardEquals(context, e, "Test guardEquals() works values are equal");
		}
		// --------------------------------------------------------------------------------------------

	}
}
