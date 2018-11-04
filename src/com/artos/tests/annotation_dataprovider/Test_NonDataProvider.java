package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "14/10/2018", bdd = "GIVEN test case is of non dataprovider type AND status is not changed THEN test should pass")
@TestCase(skip = false, sequence = 1)
public class Test_NonDataProvider implements TestExecutable {

	@Override
	public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
		System.out.println("This is non data provider test");
		// --------------------------------------------------------------------------------------------

	}
}
