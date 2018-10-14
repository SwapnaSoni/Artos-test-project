package com.artos.tests.utils_transform;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;
import com.artos.utils.Transform;

@Group(group = { "CI" })
@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "3/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_bytes_to_str_hex implements TestExecutable {

	@Override public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		Transform _tfm = new Transform();

		{
			// public String bytesToStringHex(byte[] data, boolean bDisplaySize)
			byte[] test1 = { 0, 1, 2, 10, (byte) 255 };
			String expectedResult1 = "[5][00 01 02 0A FF]";
			String resultArray1 = _tfm.bytesToHexString(test1, true);
			Guard.guardEquals(context, "Bytes To String Hex with size", expectedResult1, resultArray1);

			byte[] test2 = { 0, 1, 2, 10, (byte) 255 };
			String expectedResult2 = "0001020AFF";
			String resultArray2 = _tfm.bytesToHexString(test2, false);
			Guard.guardEquals(context, "Bytes To String Hex without size", expectedResult2, resultArray2);
		}

		{
			// public String bytesToStringHex(byte data, boolean bDisplaySize)
			byte test3 = (byte) 255;
			String expectedResult3 = "[1][FF]";
			String resultArray3 = _tfm.bytesToHexString(test3, true);
			Guard.guardEquals(context, "Byte To String Hex with size", expectedResult3, resultArray3);

			byte test4 = (byte) 255;
			String expectedResult4 = "FF";
			String resultArray4 = _tfm.bytesToHexString(test4, false);
			Guard.guardEquals(context, "Byte To String Hex without size", expectedResult4, resultArray4);
		}
		// --------------------------------------------------------------------------------------------

	}
}
