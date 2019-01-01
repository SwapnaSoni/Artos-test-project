package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "14/10/2018", bdd = "")
@TestCase(skip = false, sequence = 7, dataprovider = "NonStaticUserNamesSingleDimention")
public class Test_Single_Dimention_DataProvider implements TestExecutable {

	@Override
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		System.out.println("This is empty data provider test");
		System.out.println("data1 : " + context.getParameterisedObject1());
		System.out.println("data2 : " + context.getParameterisedObject2());
		// --------------------------------------------------------------------------------------------

	}
}
