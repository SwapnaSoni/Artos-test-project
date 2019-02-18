package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestImportance;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.Importance;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestImportance(Importance.CRITICAL)
@TestPlan(preparedBy = "arpit", preparationDate = "14/10/2018", bdd = "GIVEN test case is of non dataprovider type AND status is not changed THEN test should pass")
@TestCase(skip = false, sequence = 1)
public class Test_NonDataProvider implements TestExecutable {

	@TestImportance(Importance.CRITICAL)
	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		System.out.println("This is non data provider test");
		// --------------------------------------------------------------------------------------------

	}
}
