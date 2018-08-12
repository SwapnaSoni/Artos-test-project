package unit_test.Tree;

import java.util.ArrayList;

import com.artos.framework.ScanTestSuite;
import com.artos.framework.infra.Runner;
import com.artos.interfaces.PrePostRunnable;
import com.artos.interfaces.TestExecutable;

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
			tests = (ArrayList<TestExecutable>) new ScanTestSuite("unit_test.Tree").getTestList(true, true);
		}
		return tests;
	}

	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(Main.class);
		runner.run(args, getTestList(), 1);
	}

}
