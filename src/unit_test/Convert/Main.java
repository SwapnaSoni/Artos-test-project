package unit_test.Convert;

import java.util.ArrayList;

import com.arpitos.framework.MAIN;
import com.arpitos.interfaces.TestExecutor;

public class Main {

	public static void main(String[] args) throws Exception {
		int testLoopCount = 1;
		String serialNumber = "A123456789";
		ArrayList<TestExecutor> tests = new ArrayList<TestExecutor>();

		// --------------------------------------------------------------------------------------------
		tests.add(new TEST_CONCAT());
		tests.add(new TEST_BYTES_TO_STR_HEX());
		tests.add(new TEST_BYTES_TO_ASCII());
		tests.add(new TEST_BYTES_TO_LONG());
		// --------------------------------------------------------------------------------------------

		MAIN.run(new Start(), tests, new Finish(), Main.class.getPackage().getName(), serialNumber, testLoopCount);
	}
}