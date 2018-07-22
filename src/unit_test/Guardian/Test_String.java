package unit_test.Guardian;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Guardian;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "13/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_String implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "JIRA-????");
		// --------------------------------------------------------------------------------------------
		Guardian.guardEquals("Test String isEqual() works", true, Guardian.isEquals("ABCD", "ABCD"));
		Guardian.guardEquals("Test String isEqual() works", false, Guardian.isEquals("ABCDE", "ABCD"));

		Guardian.guardEquals("Test String isEqual() works", "ABC", "ABC");
		Guardian.guardEquals("Test String isEqual() works", "ABC-123", "ABC-123");
		try {
			Guardian.guardEquals("Test guardTrue() works", "ABC", "123");
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardTrue() works values are not equal");
		}

		Guardian.guardNotEquals("Test String isEqual() works", "ABC", "");
		Guardian.guardNotEquals("Test String isEqual() works", "ABC", "ABCD");
		Guardian.guardNotEquals("Test String isEqual() works", "ABC", "abc");
		try {
			Guardian.guardNotEquals("Test guardTrue() works", "ABCD", "ABCD");
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardTrue() works values are equal");
		}
		// --------------------------------------------------------------------------------------------

	}
}
