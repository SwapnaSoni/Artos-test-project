package unit_test.PropertiesFileReader;

import java.io.File;
import java.util.HashMap;

import org.apache.logging.log4j.Logger;

import com.arpitos.infra.TestContext;
import com.arpitos.infra.annotation.Testcase;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.PropertiesFileReader;

//@formatter:off
@Testcase(skip = false, scenario = "TEST_BYTES_TO_ASCII",
decription = "\nGIVEN : PropertiesFileReader() object is used"
           + "\nAND   : PropertiesFile is present in given location with appropriate tags"
           + "\nWHEN  : setValue() is exercised"
           + "\nTHEN  : value should be set to properties file buffer"
           + "\nAND   : it is not written to properties file"
           + "\nWHEN  : getValue() is exercised"
           + "\nTHEN  : value should be retruned from buffer"
, preparedBy = "arpit", preparationDate = "8/04/2018", reviewedBy = "", reviewDate = "")
//@formatter:on
public class TEST_PROPERTIES_FILE_READER implements TestExecutable {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, TEST_PROPERTIES_FILE_READER.class);
	}

	public void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "");
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