package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Transform;

@TestPlan(preparedBy = "arpit", preparationDate = "27/10/2018", bdd = "")
@TestCase(skip = false, sequence = 0, dataprovider = "NonStaticUserNamesIntegerByteArray")
public class Test_IntegerAndByteArray implements TestExecutable {

	@Override
	public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		Transform tfm = new Transform();
		String data1toString = Integer.toString((Integer) data1);
		String data2toString = tfm.bytesToHexString((byte[]) data2);
		System.out.println(data1toString + ":" + data2toString);
		if (data2toString.startsWith("0"
				+ ""
				+ "1")) {
			context.setTestStatus(TestStatus.FAIL, "");
		}
		// --------------------------------------------------------------------------------------------

	}
}
