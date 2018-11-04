package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "14/10/2018", bdd = "GIVEN data provider method is public but not static THEN data provider should work as expected")
@TestCase(skip = false, sequence = 3, dataprovider = "NonStaticUserNamesStringInteger")
public class Test_NonStatic_DataProvider implements TestExecutable {

	@Override
	public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		System.out.println(data1 + ":" + data2);
		// --------------------------------------------------------------------------------------------

	}

}
