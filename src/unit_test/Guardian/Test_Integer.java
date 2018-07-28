package unit_test.Guardian;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Guardian;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "13/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Integer implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		Guardian.guardEquals("Test isEqual() works", true, Guardian.isEquals(123, 123));
		Guardian.guardEquals("Test isEqual() works", true, Guardian.isEquals(Integer.MAX_VALUE, Integer.MAX_VALUE));
		Guardian.guardEquals("Test isEqual() works", true, Guardian.isEquals(Integer.MIN_VALUE, Integer.MIN_VALUE));
		Guardian.guardEquals("Test isEqual() works", false, Guardian.isEquals(12345, 12347));

		Guardian.guardEquals("Test guardEquals() works", 99999, 99999);
		Guardian.guardEquals("Test guardEquals() works", Integer.MAX_VALUE, Integer.MAX_VALUE);
		Guardian.guardEquals("Test guardEquals() works", Integer.MIN_VALUE, Integer.MIN_VALUE);
		try {
			Guardian.guardEquals("Test guardEquals() works", 9999, 9990);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardEquals() works values are not equal");
		}

		Guardian.guardEquals("Test guardEquals() works", Integer.MAX_VALUE - 2, Integer.MAX_VALUE, 5);
		Guardian.guardEquals("Test guardEquals() works", Integer.MIN_VALUE + 1, Integer.MIN_VALUE, 5);
		try {
			Guardian.guardEquals("Test guardEquals() works", 999999, 999990, 2);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardEquals() works values are not equal");
		}

		Guardian.guardNotEquals("Test guardEquals() works", 123456, 345678);
		Guardian.guardNotEquals("Test guardEquals() works", Integer.MAX_VALUE, Integer.MIN_VALUE);
		try {
			Guardian.guardNotEquals("Test guardEquals() works", 1239999, 1239999);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardEquals() works values are equal");
		}
		// --------------------------------------------------------------------------------------------

	}
}
