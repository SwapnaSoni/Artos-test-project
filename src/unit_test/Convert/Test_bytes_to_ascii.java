package unit_test.Convert;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Convert;
import com.arpitos.utils.Guardian;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "3/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_bytes_to_ascii implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, Test_bytes_to_ascii.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "JIRA-????");
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
