package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "14/10/2018", bdd = "data provider can return object which is 1D")
@TestCase(skip = false, sequence = 7)
public class Test_Single_Dimention_DataProvider implements TestExecutable {

	@Unit(dataprovider = "NonStaticUserNamesSingleDimention")
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		System.out.println("This is empty data provider test");
		System.out.println("data1 : " + context.getParameterisedObject1());
		System.out.println("data2 : " + context.getParameterisedObject2());
		// --------------------------------------------------------------------------------------------

	}
}
