package com.artos.tests.annotation_dataprovider;

import java.io.InvalidObjectException;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@ExpectedException(expectedExceptions = { InvalidObjectException.class })
@TestPlan(preparedBy = "arpit", preparationDate = "14/10/2018", bdd = "")
@TestCase(skip = false, sequence = 4, dataprovider = "InvalidDataProvider")
public class Test_Invalid_DataProvider_Name implements TestExecutable {

	@Override
	public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		System.out.println(data1 + ":" + data2);
		// --------------------------------------------------------------------------------------------

	}
}
