package unit_test.Convert;

import java.nio.ByteOrder;

import com.arpitos.infra.Enums.TestStatus;
import com.arpitos.infra.annotation.Testcase;
import com.arpitos.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Convert;
import com.arpitos.utils.Guardian;

//@formatter:off
@Testcase(skip = false, scenario = "Test_bytes_to_long",
decription = "\nGIVEN : bytesToLong() function is used from Convert class"
           + "\nWHEN  : valid byte or byte[] is provided as an argument"
           + "\nTHEN  : long formatted value should be returned"
, preparedBy = "arpit", preparationDate = "8/04/2018", reviewedBy = "", reviewDate = "")
//@formatter:on
public class Test_bytes_to_long implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, Test_bytes_to_long.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "");
		// --------------------------------------------------------------------------------------------
		Convert _con = new Convert();

		{
			// public long bytesToLong(byte[] bytes, ByteOrder bo)
			byte[] test1 = _con.stringHexToByteArray("0D E0 B6 B3 A7 63 FF FF");
			long expectedResult1 = 999999999999999999l;
			Long resultArray1 = _con.bytesToLong(test1, ByteOrder.BIG_ENDIAN);
			Guardian.guardEquals("Bytes To Long Big Endian", expectedResult1, resultArray1);

			byte[] test2 = _con.stringHexToByteArray("FF FF 63 A7 B3 B6 E0 0D");
			long expectedResult2 = 999999999999999999l;
			Long resultArray2 = _con.bytesToLong(test2, ByteOrder.LITTLE_ENDIAN);
			Guardian.guardEquals("Bytes To Long Big Endian", expectedResult2, resultArray2);
		}

		{
			// bad path with extra byte
			try {
				byte[] test2 = _con.stringHexToByteArray("FF FF 63 A7 B3 B6 E0 0D 01");
				_con.bytesToLong(test2, ByteOrder.LITTLE_ENDIAN);
				context.getLogger().info("Did not expect to reach here");
				context.setCurrentTestStatus(TestStatus.FAIL);
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