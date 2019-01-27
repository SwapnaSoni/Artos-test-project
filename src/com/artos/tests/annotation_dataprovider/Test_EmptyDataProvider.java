package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "14/10/2018", bdd = "GIVEN dataprovider annotation is used" + "AND dataprovider method is mentioned"
		+ "AND dataprovider method returns no value" + "THEN testcase is executed with data provider object value to be null")
@TestCase(skip = false, sequence = 8, dataprovider = "EmptyDataProvider")
public class Test_EmptyDataProvider implements TestExecutable {

	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		System.out.println("This is empty data provider test");
		System.out.println("data1 : " + context.getParameterisedObject1());
		System.out.println("data2 : " + context.getParameterisedObject2());
		// --------------------------------------------------------------------------------------------

	}
}
