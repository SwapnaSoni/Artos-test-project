package unit_test.PropertiesFileReader;

import java.io.File;
import java.util.HashMap;

import org.apache.logging.log4j.Logger;

import com.arpitos.infra.TestContext;
import com.arpitos.infra.annotation.TestCase;
import com.arpitos.infra.annotation.TestPlan;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.PropertiesFileReader;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "3/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_properties_file_reader implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, Test_properties_file_reader.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "JIRA-????");
		// --------------------------------------------------------------------------------------------
		Logger logger = context.getLogger();

		File file = new File("./assets/properties/test.properties");
		PropertiesFileReader propReader = new PropertiesFileReader(file);

		// Set Value in single
		propReader.setValue("A", "A");
		propReader.setValue("B", "A12344321");
		propReader.setValue("C", "A22222222");

		// set value using hash map
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("D", "1234");
		hmap.put("E", "ABCD");
		propReader.setValue(hmap);

		// Get Value without default param
		logger.debug(propReader.getValue("A"));
		logger.debug(propReader.getValue("B"));
		logger.debug(propReader.getValue("C"));
		logger.debug(propReader.getValue("D"));
		logger.debug(propReader.getValue("E"));

		// Get valid Value with default param
		logger.debug(propReader.getValue("A", "New"));

		// Get invalid Value with default param
		logger.debug(propReader.getValue("Z", "New"));

		// Get invalid Value without default param
		logger.debug(propReader.getValue("Z"));
		// --------------------------------------------------------------------------------------------

	}
}
