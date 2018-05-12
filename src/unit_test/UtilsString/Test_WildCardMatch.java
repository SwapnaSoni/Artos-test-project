package unit_test.UtilsString;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Guardian;
import com.arpitos.utils.UtilsString;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "12/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_WildCardMatch implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, Test_WildCardMatch.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "JIRA-????");
		// --------------------------------------------------------------------------------------------
		String str = "THISisArpitos_Test12345@#$%";

		String pattern = "*arpitos*";
		Guardian.guardEquals("WildCardMatch", false, UtilsString.wildCardMatch(str, pattern));
		pattern = "This*";
		Guardian.guardEquals("WildCardMatch", false, UtilsString.wildCardMatch(str, pattern));
		pattern = "*123*THIS*";
		Guardian.guardEquals("WildCardMatch", false, UtilsString.wildCardMatch(str, pattern));
		pattern = "%*";
		Guardian.guardEquals("WildCardMatch", false, UtilsString.wildCardMatch(str, pattern));
		pattern = "*T";
		Guardian.guardEquals("WildCardMatch", false, UtilsString.wildCardMatch(str, pattern));
		pattern = "*z*";
		Guardian.guardEquals("WildCardMatch", false, UtilsString.wildCardMatch(str, pattern));
		
		
		pattern = "*Arpitos*";
		Guardian.guardEquals("WildCardMatch", true, UtilsString.wildCardMatch(str, pattern));
		pattern = "THIS*";
		Guardian.guardEquals("WildCardMatch", true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*THIS*123*";
		Guardian.guardEquals("WildCardMatch", true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*%";
		Guardian.guardEquals("WildCardMatch", true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*%*";
		Guardian.guardEquals("WildCardMatch", true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*%**";
		Guardian.guardEquals("WildCardMatch", true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*Test*5*%";
		Guardian.guardEquals("WildCardMatch", true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*****";
		Guardian.guardEquals("WildCardMatch", true, UtilsString.wildCardMatch(str, pattern));
		pattern = "*T*H*I*S*i*s*A*r*p*i*t*o*s*_*T*e*s*t*1*2*3*4*5*@*#*$*%*";
		Guardian.guardEquals("WildCardMatch", true, UtilsString.wildCardMatch(str, pattern));
		// --------------------------------------------------------------------------------------------

	}
}
