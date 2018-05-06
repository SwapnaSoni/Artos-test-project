package unit_test.Convert;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Convert;
import com.arpitos.utils.Guardian;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "3/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_bytes_to_str_hex implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, Test_bytes_to_str_hex.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "JIRA-????");
		// --------------------------------------------------------------------------------------------
		Convert _con = new Convert();

		{
			// public String bytesToStringHex(byte[] data, boolean bDisplaySize)
			byte[] test1 = { 0, 1, 2, 10, (byte) 255 };
			String expectedResult1 = "[5][00 01 02 0A FF]";
			String resultArray1 = _con.bytesToStringHex(test1, true);
			Guardian.guardEquals("Bytes To String Hex with size", expectedResult1, resultArray1);

			byte[] test2 = { 0, 1, 2, 10, (byte) 255 };
			String expectedResult2 = "0001020AFF";
			String resultArray2 = _con.bytesToStringHex(test2, false);
			Guardian.guardEquals("Bytes To String Hex without size", expectedResult2, resultArray2);
		}

		{
			// public String bytesToStringHex(byte data, boolean bDisplaySize)
			byte test3 = (byte) 255;
			String expectedResult3 = "[1][FF]";
			String resultArray3 = _con.bytesToStringHex(test3, true);
			Guardian.guardEquals("Byte To String Hex with size", expectedResult3, resultArray3);

			byte test4 = (byte) 255;
			String expectedResult4 = "FF";
			String resultArray4 = _con.bytesToStringHex(test4, false);
			Guardian.guardEquals("Byte To String Hex without size", expectedResult4, resultArray4);
		}
		// --------------------------------------------------------------------------------------------

	}
}
