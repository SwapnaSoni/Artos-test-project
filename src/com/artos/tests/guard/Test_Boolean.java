package com.artos.tests.guard;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "13/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Boolean implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		// guardTrue(), guardFalse() and isEquals()
		Guard.guardTrue(context, "Test guardTrue() works", Guard.isEquals(true, true));
		Guard.guardFalse(context, "Test guardTrue() works", Guard.isEquals(true, false));
		// guardTrue() badPath
		try {
			Guard.guardTrue(context, "Test guardTrue() works", false);
			Guard.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guard.guardEquals(context, e, "Test guardTrue() works values are not equal");
		}
		try {
			Guard.guardFalse(context, "Test guardFalse() works", true);
			Guard.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guard.guardEquals(context, e, "Test guardFalse() works values are not equal");
		}

		// guardEquals()
		Guard.guardEquals(context, "Test guardEquals() works", true, true);
		Guard.guardEquals(context, "Test guardEquals() works", false, false);
		try {
			Guard.guardEquals(context, "Test guardEquals() works", true, false);
			Guard.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guard.guardEquals(context, e, "Test guardEquals() works values are not equal");
		}

		// guardNotEquals()
		Guard.guardNotEquals(context, "Test guardNotEquals works", true, false);
		Guard.guardNotEquals(context, "Test guardNotEquals works", false, true);
		try {
			Guard.guardNotEquals(context, "Test guardNotEquals() works", true, true);
			Guard.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guard.guardEquals(context, e, "Test guardNotEquals() works values are equal");
		}
		try {
			Guard.guardNotEquals(context, "Test guardNotEquals() works", false, false);
			Guard.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guard.guardEquals(context, e, "Test guardNotEquals() works values are equal");
		}
		// --------------------------------------------------------------------------------------------

	}
}
