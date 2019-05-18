package com.artos.tests.annotation_dataprovider;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "14/10/2018", bdd = "Given data provider is used AND test case sets different status based on data provided then extent report will log status as part of child test")
@TestCase(skip = false, sequence = 5)
public class Test_ExtentReport_Child_Status implements TestExecutable {

	@Unit(dataprovider = "StaticUserNamesStringString")
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		if (((String) context.getParameterisedObject2()).equals("Test@123")) {
			context.setTestStatus(TestStatus.PASS, "123");
		}
		if (((String) context.getParameterisedObject2()).equals("Test@456")) {
			context.setTestStatus(TestStatus.FAIL, "456");
		}
		if (((String) context.getParameterisedObject2()).equals("Test@789")) {
			context.setTestStatus(TestStatus.SKIP, "789");
		}
		if (((String) context.getParameterisedObject2()).equals("Test@000")) {
			context.setTestStatus(TestStatus.KTF, "000");
		}
		// --------------------------------------------------------------------------------------------

	}
}
