package unit_test.Convert;

import java.nio.ByteOrder;

import com.arpit.framework.Test;
import com.arpit.infra.TestContext;
import com.arpit.infra.TestContext.Status;
import com.arpit.interfaces.TestExecutor;
import com.arpit.utils.Convert;
import com.arpit.utils.Guardian;
import com.arpit.utils.Guardian.GuardCheckFor;

/***
 * 
 * <PRE>
 * START_OF_TEST_HEADER
 * TEST_TARGET			= 	TEST_BYTES_TO_LONG
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
public class TEST_BYTES_TO_LONG extends Test implements TestExecutor {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, TEST_BYTES_TO_LONG.class, "arpit_000", "18/09/2016", "");
	}

	protected void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "");
		// --------------------------------------------------------------------------------------------
		Convert _con = new Convert();

		{
			// public long bytesToLong(byte[] bytes, ByteOrder bo)
			byte[] test1 = _con.stringHexToByteArray("0D E0 B6 B3 A7 63 FF FF");
			long expectedResult1 = 999999999999999999l;
			Long resultArray1 = _con.bytesToLong(test1, ByteOrder.BIG_ENDIAN);
			Guardian.guard(context, GuardCheckFor.EQUAL_TO, "Bytes To Long Big Endian", expectedResult1, resultArray1);

			byte[] test2 = _con.stringHexToByteArray("FF FF 63 A7 B3 B6 E0 0D");
			long expectedResult2 = 999999999999999999l;
			Long resultArray2 = _con.bytesToLong(test2, ByteOrder.LITTLE_ENDIAN);
			Guardian.guard(context, GuardCheckFor.EQUAL_TO, "Bytes To Long Big Endian", expectedResult2, resultArray2);
		}

		{
			// bad path with extra byte
			try {
				byte[] test2 = _con.stringHexToByteArray("FF FF 63 A7 B3 B6 E0 0D 01");
				_con.bytesToLong(test2, ByteOrder.LITTLE_ENDIAN);
				context.getLogger().info("Did not expect to reach here");
				context.setCurrentTestStatus(Status.FAIL);
			} catch (Exception e) {
				if (!e.getMessage().contains("Invalid Input Data, Can not be more than 8 bytes")) {
					throw e;
				}
			}
		}

		{
			// bad path with value larger than 9,99,99,99,99,99,99,99,999
			byte[] test2 = _con.stringHexToByteArray("FF FF FF FF FF FF FF FF");
			_con.bytesToLong(test2, ByteOrder.LITTLE_ENDIAN);
		}
		// --------------------------------------------------------------------------------------------

	}
}