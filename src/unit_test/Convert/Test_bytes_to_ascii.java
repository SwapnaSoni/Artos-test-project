package unit_test.Convert;

import com.arpitos.infra.TestContext;
import com.arpitos.infra.annotation.Testcase;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Convert;
import com.arpitos.utils.Guardian;

// @formatter:off
@Testcase(skip = false, scenario = "Test_bytes_to_ascii",
decription = "\nGIVEN : bytetoAscii() function is used from Convert class"
           + "\nWHEN  : Byte or byte array is provided as an argument"
           + "\nTHEN  : ASCII formated String should be returned"
, preparedBy = "arpit", preparationDate = "8/04/2018", reviewedBy = "", reviewDate = "")
// @formatter:on
public class Test_bytes_to_ascii implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, Test_bytes_to_ascii.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "JIRA-1234");
		// --------------------------------------------------------------------------------------------
		Convert _con = new Convert();

		{
			// public String bytesToStringHex(byte data, boolean bDisplaySize)
			byte[] test1 = { (byte) 0x54, (byte) 0x45, (byte) 0x53, (byte) 0x54 };
			String expectedResult1 = "TEST";
			String resultArray1 = _con.bytesToAscii(test1);
			Guardian.guardEquals("Bytes To ASCII", expectedResult1, resultArray1);
		}

		{
			// public String bytesToAscii(byte data)
			byte test2 = (byte) 0x54;
			String expectedResult2 = "T";
			String resultArray2 = _con.bytesToAscii(test2);
			Guardian.guardEquals("Byte To ASCII", expectedResult2, resultArray2);
		}
		// --------------------------------------------------------------------------------------------

	}
}