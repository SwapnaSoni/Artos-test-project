package unit_test.PropertiesFileReader;

import java.util.ArrayList;

import com.arpitos.framework.Runner;
import com.arpitos.interfaces.TestExecutable;

import unit_test.PrePostCycle;


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
		Runner.run(new PrePostCycle(), getTestList(), Main.class, serialNumber, testLoopCount);
	}

}