package com.artos.tests.utils_transform;

import java.nio.ByteOrder;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;
import com.artos.utils.Transform;

@Group(group = { "CI_AT" })
@TestPlan(description = "", preparedBy = "arpit", preparationDate = "3/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_bytes_to_long implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		Transform _tfm = new Transform();

		{
			// public long bytesToLong(byte[] bytes, ByteOrder bo)
			byte[] test1 = _tfm.strHexToByteArray("0D E0 B6 B3 A7 63 FF FF");
			long expectedResult1 = 999999999999999999l;
			Long resultArray1 = _tfm.bytesToLong(test1, ByteOrder.BIG_ENDIAN);
			Guard.guardEquals(context, "Bytes To Long Big Endian", expectedResult1, resultArray1);

			byte[] test2 = _tfm.strHexToByteArray("FF FF 63 A7 B3 B6 E0 0D");
			long expectedResult2 = 999999999999999999l;
			Long resultArray2 = _tfm.bytesToLong(test2, ByteOrder.LITTLE_ENDIAN);
			Guard.guardEquals(context, "Bytes To Long Big Endian", expectedResult2, resultArray2);
		}

		{
			// bad path with extra byte, should only take first 8 bytes into
			// consideration
			byte[] test2 = _tfm.strHexToByteArray("FF FF 63 A7 B3 B6 E0 0D 01");
			_tfm.bytesToLong(test2, ByteOrder.LITTLE_ENDIAN);
		}

		{
			// bad path with value larger than 9,99,99,99,99,99,99,99,999
			byte[] test2 = _tfm.strHexToByteArray("FF FF FF FF FF FF FF FF");
			_tfm.bytesToLong(test2, ByteOrder.LITTLE_ENDIAN);
		}
		// --------------------------------------------------------------------------------------------

	}
}
