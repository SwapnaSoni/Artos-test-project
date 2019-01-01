package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "14/10/2018", bdd = "" + "GIVEN dataprovider annotation is used "
		+ "AND data provider method is within scanning scope " + "THEN dataprovider method will be searched which will be case in-sensitive")
@TestCase(skip = false, sequence = 4, dataprovider = "non_static_string_string")
public class Test_DataProvider_Ignore_Case implements TestExecutable {

	@Override
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		System.out.println("Actual data provider name is in Capital");
		System.out.println(context.getParameterisedObject1() + ":" + context.getParameterisedObject2());
		// --------------------------------------------------------------------------------------------

	}
}
