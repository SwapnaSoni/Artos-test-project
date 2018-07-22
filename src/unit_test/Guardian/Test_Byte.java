package unit_test.Guardian;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Guardian;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "13/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_Byte implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "JIRA-????");
		// --------------------------------------------------------------------------------------------
		Guardian.guardEquals("Test isEqual() works", true, Guardian.isEquals((byte) 0x01, (byte) 0x01));
		Guardian.guardEquals("Test isEqual() works", true, Guardian.isEquals((byte) 0xFF, (byte) 0xFF));
		Guardian.guardEquals("Test isEqual() works", true, Guardian.isEquals((byte) 0x00, (byte) 0x00));
		Guardian.guardEquals("Test isEqual() works", false, Guardian.isEquals((byte) 0x01, (byte) 0x02));

		Guardian.guardEquals("Test guardEquals() works", (byte) 0x00, (byte) 0x00);
		Guardian.guardEquals("Test guardEquals() works", (byte) 0x01, (byte) 0x01);
		Guardian.guardEquals("Test guardEquals() works", (byte) 0xFF, (byte) 0xFF);
		try {
			Guardian.guardEquals("Test guardEquals() works", (byte) 0xFA, (byte) 0xFF);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardEquals() works values are not equal");
		}

		Guardian.guardEquals("Test guardEquals() works", (byte) 0xFE, (byte) 0xFF, (byte) 0x05);
		Guardian.guardEquals("Test guardEquals() works", (byte) 0x00, (byte) 0x05, (byte) 0x05);
		try {
			Guardian.guardEquals("Test guardEquals() works", (byte) 0xFA, (byte) 0xFF, (byte) 0x02);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardEquals() works values are not equal");
		}

		Guardian.guardNotEquals("Test guardEquals() works", (byte) 0x00, (byte) 0x01);
		Guardian.guardNotEquals("Test guardEquals() works", (byte) 0x01, (byte) 0xFF);
		try {
			Guardian.guardNotEquals("Test guardEquals() works", (byte) 0xFF, (byte) 0xFF);
			Guardian.guardWrongFlow("Did not expect to reach here");
		} catch (Exception e) {
			Guardian.guardEquals(e, "Test guardEquals() works values are equal");
		}
		// --------------------------------------------------------------------------------------------

	}
}
