package unit_test.Guardian;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Guardian;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "13/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Boolean implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		// guardTrue(), guardFalse() and isEquals()
		Guardian.guardTrue("Test guardTrue() works", Guardian.isEquals(true, true));
		Guardian.guardFalse("Test guardTrue() works", Guardian.isEquals(true, false));
		// guardTrue() badPath
		try {
			Guardian.guardTrue("Test guardTrue() works", false);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardTrue() works values are not equal");
		}
		try {
			Guardian.guardFalse("Test guardFalse() works", true);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardFalse() works values are not equal");
		}

		// guardEquals()
		Guardian.guardEquals("Test guardEquals() works", true, true);
		Guardian.guardEquals("Test guardEquals() works", false, false);
		try {
			Guardian.guardEquals("Test guardEquals() works", true, false);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardEquals() works values are not equal");
		}

		// guardNotEquals()
		Guardian.guardNotEquals("Test guardNotEquals works", true, false);
		Guardian.guardNotEquals("Test guardNotEquals works", false, true);
		try {
			Guardian.guardNotEquals("Test guardNotEquals() works", true, true);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardNotEquals() works values are equal");
		}
		try {
			Guardian.guardNotEquals("Test guardNotEquals() works", false, false);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardNotEquals() works values are equal");
		}
		// --------------------------------------------------------------------------------------------

	}
}
