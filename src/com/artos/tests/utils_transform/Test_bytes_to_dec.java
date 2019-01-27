package com.artos.tests.utils_transform;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;
import com.artos.utils.Transform;

@TestPlan(description = "", preparedBy = "arpit", preparationDate = "28/09/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_bytes_to_dec implements TestExecutable {

	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		Transform _tfm = new Transform();
		byte[] test2 = _tfm.strHexToByteArray("0D E0 B6 B3 A7 63 FF FF");
		long expectedResult4 = 999999999999999999l;
		long resultArray4 = _tfm.bytesToDecimals(test2);
		Guard.guardEquals(context, "Bytes to Dec", expectedResult4, resultArray4);
		// --------------------------------------------------------------------------------------------

	}
}
