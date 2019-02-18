package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestImportance;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.Importance;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Transform;

@TestImportance(Importance.CRITICAL)
@TestPlan(preparedBy = "arpit", preparationDate = "27/10/2018", bdd = "Dataprovider can provide data as integer or byte array")
@TestCase(skip = false, sequence = 0)
public class Test_IntegerAndByteArray implements TestExecutable {

	@TestImportance(Importance.CRITICAL)
	@Unit(dataprovider = "NonStaticUserNamesIntegerByteArray")
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		Transform tfm = new Transform();
		String data1toString = Integer.toString((Integer) context.getParameterisedObject1());
		String data2toString = tfm.bytesToHexString((byte[]) context.getParameterisedObject2());
		System.out.println(data1toString + ":" + data2toString);
		if (data2toString.startsWith("0" + "" + "1")) {
			context.setTestStatus(TestStatus.FAIL, "");
		}
		// --------------------------------------------------------------------------------------------

	}
}
