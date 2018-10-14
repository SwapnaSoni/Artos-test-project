package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@ExpectedException(expectedExceptions = { ClassCastException.class })
@TestPlan(preparedBy = "arpit", preparationDate = "14/10/2018", bdd = "")
@TestCase(skip = false, sequence = 5, dataprovider = "NonStaticUserNamesStringString")
public class Test_DataProvider_Wrong_Casting implements TestExecutable {

	@Override
	public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		int integerData = (int) data1;
		String stringData = (String) data2;

		System.out.println(integerData + stringData);
		// --------------------------------------------------------------------------------------------

	}
}
