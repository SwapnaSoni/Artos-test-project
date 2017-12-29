package unit_test.TCPServer;

import java.util.ArrayList;

import com.arpitos.framework.MAIN;
import com.arpitos.interfaces.TestExecutor;

import unit_test.PropertiesFileReader.TEST_PROPERTIES_FILE_READER;

public class Main {

	public static void main(String[] args) throws Exception {
		int testLoopCount = 1;
		String serialNumber = "A123456789";
		ArrayList<TestExecutor> tests = new ArrayList<TestExecutor>();

		// --------------------------------------------------------------------------------------------
		tests.add(new TEST_PROPERTIES_FILE_READER());
		// --------------------------------------------------------------------------------------------

		MAIN.run(new Start(), tests, new Finish(), Main.class.getPackage().getName(), serialNumber, testLoopCount);
	}
}