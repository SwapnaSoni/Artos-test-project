package unit_test.CustomPrompt;

import java.util.ArrayList;

import com.arpit.framework.Tester;
import com.arpit.interfaces.TestExecutor;

public class MAIN {

	public static void main(String[] args) throws Exception {
		int TestLoopCount = 1;
		ArrayList<TestExecutor> tests = new ArrayList<TestExecutor>();

		// --------------------------------------------------------------------------------------------
		tests.add(new TEST_COUNTDOWN_TIMER());
		// --------------------------------------------------------------------------------------------

		Tester.run(new START(), tests, new FINISH(), MAIN.class.getPackage().getName(), TestLoopCount);
	}
}