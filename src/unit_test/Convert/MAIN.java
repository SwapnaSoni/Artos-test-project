package unit_test.Convert;

import java.util.ArrayList;

import com.arpit.framework.Tester;
import com.arpit.interfaces.TestExecutor;

public class MAIN {

	public static void main(String[] args) throws Exception {
		int TestLoopCount = 1;
		ArrayList<TestExecutor> tests = new ArrayList<TestExecutor>();

		// --------------------------------------------------------------------------------------------
		tests.add(new TEST_CONCAT());
		tests.add(new TEST_BYTES_TO_STR_HEX());
		tests.add(new TEST_BYTES_TO_ASCII());
		tests.add(new TEST_BYTES_TO_LONG());
		// --------------------------------------------------------------------------------------------

		Tester.run(new START(), tests, new FINISH(), MAIN.class.getPackage().getName(), TestLoopCount);
	}
}