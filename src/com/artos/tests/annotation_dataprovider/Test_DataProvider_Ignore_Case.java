package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "14/10/2018", bdd = "")
@TestCase(skip = false, sequence = 0, dataprovider = "non_static_string_string")
public class Test_DataProvider_Ignore_Case implements TestExecutable {

	@Override
	public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		System.out.println("Actual data provider name is in Capital");
		System.out.println(data1 + ":" + data2);
		// --------------------------------------------------------------------------------------------

	}
}
