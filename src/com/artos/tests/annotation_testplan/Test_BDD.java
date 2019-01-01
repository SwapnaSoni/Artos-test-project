package com.artos.tests.annotation_testplan;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "8/10/2018", bdd = "GIVEN Given given agiven givenb agivenb WHEN When when awhen whenb awhenb THEN Then then athen thenb athenb AND And and aand andb aandb BUT But but abut butb abutb")
@TestCase(skip = false, sequence = 0)
public class Test_BDD implements TestExecutable {

	@Override public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		// TODO Write Test Here
		// --------------------------------------------------------------------------------------------

	}
}
