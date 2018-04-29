package unit_test;

import java.util.ArrayList;

import com.arpitos.framework.Runner;
import com.arpitos.interfaces.TestExecutable;

public class Main {

	public static ArrayList<TestExecutable> getTestList() {
		ArrayList<TestExecutable> tests = new ArrayList<TestExecutable>();

		//--------------------------------------------------------------------------------------------
		tests.addAll(unit_test.Convert.Main.getTestList());
		tests.addAll(unit_test.CustomPrompt.Main.getTestList());
		tests.addAll(unit_test.PropertiesFileReader.Main.getTestList());
		tests.addAll(unit_test.ZipTar.Main.getTestList());
		//--------------------------------------------------------------------------------------------

		return tests;
	}

	public static void main(String[] args) throws Exception {
		int testLoopCount = 1;
		String serialNumber = "A123456789";
		Runner.run(new PrePostCycle(), getTestList(), Main.class, serialNumber, testLoopCount);
	}

}