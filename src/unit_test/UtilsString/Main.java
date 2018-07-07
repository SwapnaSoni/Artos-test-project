package unit_test.UtilsString;

import java.util.ArrayList;

import com.arpitos.framework.ScanTestSuite;
import com.arpitos.framework.infra.Runner;
import com.arpitos.interfaces.PrePostRunnable;
import com.arpitos.interfaces.TestExecutable;

public class Main implements PrePostRunnable {

	public static ArrayList<TestExecutable> getTestList() throws Exception {
		ArrayList<TestExecutable> tests = new ArrayList<TestExecutable>();

		// --------------------------------------------------------------------------------------------
		// TODO User May Add Test Case Manually as show in sample below
		// tests.add(new Test_123());
		// tests.add(new Test_abc());
		// --------------------------------------------------------------------------------------------

		// User can rely on reflection to populate test cases
		if (tests.isEmpty()) {
			tests = (ArrayList<TestExecutable>) new ScanTestSuite("unit_test.UtilsString").getTestList(true, true);
		}
		return tests;
	}

	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(Main.class);
		runner.run(args, getTestList(), 1);
	}

}
