import java.util.ArrayList;

import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;

public class TestRunner {

	public static ArrayList<TestExecutable> getTestList() throws Exception {
		ArrayList<TestExecutable> tests = new ArrayList<TestExecutable>();

		// --------------------------------------------------------------------------------------------
		// tests.addAll(com.artos.tests.annotation_expectedexception.Main.getTestList());
		// tests.addAll(com.artos.tests.annotation_ktf.Main.getTestList());
		// tests.addAll(com.artos.tests.annotation_testplan.Main.getTestList());
		// --------------------------------------------------------------------------------------------

		return tests;
	}

	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(TestRunner.class);
		runner.setTestList(getTestList()); 
		runner.run(args);
	}

}
