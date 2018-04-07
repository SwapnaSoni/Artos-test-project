package unit_test.CustomPrompt;

import java.util.ArrayList;

import com.arpitos.framework.MAIN;
import com.arpitos.interfaces.TestExecutable;

import unit_test.PrePostCycle;


public class Main {

	public static ArrayList<TestExecutable> getTestList() {
		ArrayList<TestExecutable> tests = new ArrayList<TestExecutable>();

		//--------------------------------------------------------------------------------------------
		tests.add(new TEST_COUNTDOWN_TIMER());
		//--------------------------------------------------------------------------------------------

		return tests;
	}

	public static void main(String[] args) throws Exception {
		int testLoopCount = 1;
		String serialNumber = "A123456789";
		MAIN.run(new PrePostCycle(), getTestList(), Main.class, serialNumber, testLoopCount);
	}

}