package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestImportance;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.Importance;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestImportance(Importance.CRITICAL)
@TestPlan(preparedBy = "arpit", preparationDate = "14/10/2018", bdd = "GIVEN dataprovider method throws exception during execution then test will be marked as failed with appropriate warning")
@TestCase(skip = false, sequence = 8)
public class Test_Exception_in_Dataprovider implements TestExecutable {

	@TestImportance(Importance.CRITICAL)
	@Unit(dataprovider = "exceptionDataProvider")
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		System.out.println("This is empty data provider test");
		System.out.println("data1 : " + context.getParameterisedObject1());
		System.out.println("data2 : " + context.getParameterisedObject2());
		// --------------------------------------------------------------------------------------------

	}
}