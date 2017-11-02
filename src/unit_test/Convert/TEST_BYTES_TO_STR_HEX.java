package unit_test.Convert;

import com.arpit.framework.Test;
import com.arpit.infra.TestContext;
import com.arpit.interfaces.TestExecutor;
import com.arpit.utils.Convert;
import com.arpit.utils.Guardian;
import com.arpit.utils.Guardian.GuardCheckFor;

/***
 * 
 * <PRE>
 * START_OF_TEST_HEADER
 * TEST_TARGET			= 	TEST_BYTES_TO_STR_HEX
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
public class TEST_BYTES_TO_STR_HEX extends Test implements TestExecutor {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, TEST_BYTES_TO_STR_HEX.class, "arpit_000", "18/09/2016", "");
	}

	protected void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "");
		// --------------------------------------------------------------------------------------------
		Convert _con = new Convert();

		{
			// public String bytesToStringHex(byte[] data, boolean bDisplaySize)
			byte[] test1 = { 0, 1, 2, 10, (byte) 255 };
			String expectedResult1 = "[5][00 01 02 0A FF]";
			String resultArray1 = _con.bytesToStringHex(test1, true);
			Guardian.guard(context, GuardCheckFor.EQUAL_TO, "Bytes To String Hex with size", expectedResult1, resultArray1);

			byte[] test2 = { 0, 1, 2, 10, (byte) 255 };
			String expectedResult2 = "0001020AFF";
			String resultArray2 = _con.bytesToStringHex(test2, false);
			Guardian.guard(context, GuardCheckFor.EQUAL_TO, "Bytes To String Hex without size", expectedResult2, resultArray2);
		}

		{
			// public String bytesToStringHex(byte data, boolean bDisplaySize)
			byte test3 = (byte) 255;
			String expectedResult3 = "[1][FF]";
			String resultArray3 = _con.bytesToStringHex(test3, true);
			Guardian.guard(context, GuardCheckFor.EQUAL_TO, "Byte To String Hex with size", expectedResult3, resultArray3);

			byte test4 = (byte) 255;
			String expectedResult4 = "FF";
			String resultArray4 = _con.bytesToStringHex(test4, false);
			Guardian.guard(context, GuardCheckFor.EQUAL_TO, "Byte To String Hex without size", expectedResult4, resultArray4);
		}
		// --------------------------------------------------------------------------------------------

	}
}