package unit_test.Guardian;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Guardian;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "13/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Long implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		Guardian.guardEquals("Test isEqual() works", true, Guardian.isEquals(123l, 123));
		Guardian.guardEquals("Test isEqual() works", true, Guardian.isEquals(Long.MAX_VALUE, Long.MAX_VALUE));
		Guardian.guardEquals("Test isEqual() works", true, Guardian.isEquals(Long.MIN_VALUE, Long.MIN_VALUE));
		Guardian.guardEquals("Test isEqual() works", false, Guardian.isEquals(123456789l, 123456788l));

		Guardian.guardEquals("Test guardEquals() works", 9999999999l, 9999999999l);
		Guardian.guardEquals("Test guardEquals() works", Long.MAX_VALUE, Long.MAX_VALUE);
		Guardian.guardEquals("Test guardEquals() works", Long.MIN_VALUE, Long.MIN_VALUE);
		try {
			Guardian.guardEquals("Test guardEquals() works", 9999999999l, 9999999998l);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardEquals() works values are not equal");
		}

		Guardian.guardEquals("Test guardEquals() works", Long.MAX_VALUE - 2, Long.MAX_VALUE, 5);
		Guardian.guardEquals("Test guardEquals() works", Long.MIN_VALUE + 1, Long.MIN_VALUE, 5);
		try {
			Guardian.guardEquals("Test guardEquals() works", 999999l, 999990l, 2);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardEquals() works values are not equal");
		}

		Guardian.guardNotEquals("Test guardEquals() works", 123456l, 345678l);
		Guardian.guardNotEquals("Test guardEquals() works", Long.MAX_VALUE, Long.MIN_VALUE);
		try {
			Guardian.guardNotEquals("Test guardEquals() works", 1239999l, 1239999l);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardEquals() works values are equal");
		}
		// --------------------------------------------------------------------------------------------

	}
}
