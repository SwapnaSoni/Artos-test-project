package unit_test.Convert;

import com.arpitos.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Convert;
import com.arpitos.utils.Guardian;


/***
 * 
 * <PRE>
 * START_OF_TEST_HEADER
 * TEST_TARGET			= 	TEST_BYTES_TO_ASCII
 * TEST_STEPS			=	???
 * EXPECTED_RESULTS		=	???
 * DEPENDENCY			=	None
 * NOTES				=	None
 * PREPARED_BY			=	arpit_000
 * REVIEWED_BY			=	
 * REVIEW_DATE			=	dd/mm/yyyy
 * END_OF_TEST_HEADER
 * </PRE>
 */
public class TEST_BYTES_TO_ASCII implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, TEST_BYTES_TO_ASCII.class, "arpit_000", "18/09/2016", "");
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