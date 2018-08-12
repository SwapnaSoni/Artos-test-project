package unit_test.Guardian;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "13/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_String implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		Guard.guardEquals(context, "Test String isEqual() works", true, Guard.isEquals("ABCD", "ABCD"));
		Guard.guardEquals(context, "Test String isEqual() works", false, Guard.isEquals("ABCDE", "ABCD"));

		Guard.guardEquals(context, "Test String isEqual() works", "ABC", "ABC");
		Guard.guardEquals(context, "Test String isEqual() works", "ABC-123", "ABC-123");
		try {
			Guard.guardEquals(context, "Test guardTrue() works", "ABC", "123");
			Guard.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guard.guardEquals(context, e, "Test guardTrue() works values are not equal");
		}

		Guard.guardNotEquals(context, "Test String isEqual() works", "ABC", "");
		Guard.guardNotEquals(context, "Test String isEqual() works", "ABC", "ABCD");
		Guard.guardNotEquals(context, "Test String isEqual() works", "ABC", "abc");
		try {
			Guard.guardNotEquals(context, "Test guardTrue() works", "ABCD", "ABCD");
			Guard.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guard.guardEquals(context, e, "Test guardTrue() works values are equal");
		}
		// --------------------------------------------------------------------------------------------

	}
}
