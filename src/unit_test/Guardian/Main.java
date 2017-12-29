package unit_test.Guardian;

import java.util.ArrayList;

import com.arpitos.framework.MAIN;
import com.arpitos.interfaces.TestExecutor;

public class Main {

	public static void main(String[] args) throws Exception {
		int testLoopCount = 1;
		String serialNumber = "A123456789";
		ArrayList<TestExecutor> tests = new ArrayList<TestExecutor>();

		// --------------------------------------------------------------------------------------------
		// TODO Write Test Sequence Here
		// --------------------------------------------------------------------------------------------

		MAIN.run(new Start(), tests, new Finish(), Main.class.getPackage().getName(), serialNumber, testLoopCount);
	}
}