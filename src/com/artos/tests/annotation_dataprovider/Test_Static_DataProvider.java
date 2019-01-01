package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "14/10/2018", bdd = "GIVEN dataprovider method is \"public static\" THEN dataprovider should work as expected")
@TestCase(skip = false, sequence = 2, dataprovider = "StaticUserNamesStringString")
public class Test_Static_DataProvider implements TestExecutable {

	@Override
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		System.out.println(context.getParameterisedObject1() + ":" + context.getParameterisedObject2());
		// --------------------------------------------------------------------------------------------

	}

}
