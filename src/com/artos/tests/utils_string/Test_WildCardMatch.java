package com.artos.tests.utils_string;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;
import com.artos.utils.UtilsString;

@TestPlan(description = "", preparedBy = "arpit", preparationDate = "12/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_WildCardMatch implements TestExecutable {

	@Unit
	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		String str = "THISisArpitos_Test12345@#$%";

		String pattern = "*arpitos*";
		Guard.guardEquals(false, UtilsString.wildCardMatch(str, pattern));
		pattern = "This*";
		Guard.guardEquals(false, UtilsString.wildCardMatch(str, pattern));
		pattern = "*123*THIS*";
		Guard.guardEquals(false, UtilsString.wildCardMatch(str, pattern));
		pattern = "%*";
		Guard.guardEquals(false, UtilsString.wildCardMatch(str, pattern));
		pattern = "*T";
		Guard.guardEquals(false, UtilsString.wildCardMatch(str, pattern));
		pattern = "*z*";
		Guard.guardEquals(false, UtilsString.wildCardMatch(str, pattern));

		pattern = "*Arpitos*";
		Guard.guardEquals(true, UtilsString.wildCardMatch(str, pattern));
		pattern = "THIS*";
		Guard.guardEquals(true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*THIS*123*";
		Guard.guardEquals(true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*%";
		Guard.guardEquals(true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*%*";
		Guard.guardEquals(true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*%**";
		Guard.guardEquals(true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*Test*5*%";
		Guard.guardEquals(true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*****";
		Guard.guardEquals(true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*T*H*I*S*i*s*A*r*p*i*t*o*s*_*T*e*s*t*1*2*3*4*5*@*#*$*%*";
		Guard.guardEquals(true, UtilsString.wildCardMatch(str, pattern));
		// --------------------------------------------------------------------------------------------

	}
}
