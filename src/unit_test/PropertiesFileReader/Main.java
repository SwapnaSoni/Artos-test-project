package unit_test.PropertiesFileReader;

import java.util.ArrayList;

import com.arpitos.framework.MAIN;
import com.arpitos.interfaces.TestExecutable;


public class Main {

	public static ArrayList<TestExecutable> getTestList() {
		ArrayList<TestExecutable> tests = new ArrayList<TestExecutable>();

		//--------------------------------------------------------------------------------------------
		tests.add(new TEST_PROPERTIES_FILE_READER());
		//--------------------------------------------------------------------------------------------

		return tests;
	}

	public static void main(String[] args) throws Exception {
		int testLoopCount = 1;
		String serialNumber = "A123456789";
		MAIN.run(new PrePostCycle(), getTestList(), Main.class, serialNumber, testLoopCount);
	}

}