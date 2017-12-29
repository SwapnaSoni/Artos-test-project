package unit_test.PropertiesFileReader;

import java.io.File;
import java.util.HashMap;

import org.apache.logging.log4j.Logger;

import com.arpit.framework.Test;
import com.arpit.infra.OrganisedLog;
import com.arpit.infra.TestContext;
import com.arpit.interfaces.TestExecutor;
import com.arpit.utils.PropertiesFileReader;

/***
 * 
 * <PRE>
 * START_OF_TEST_HEADER
 * TEST_TARGET			= 	TEST_PROPERTIES_FILE_READER
 * TEST_STEPS			=	???
 * EXPECTED_RESULTS		=	???
 * DEPENDENCY			=	None
 * NOTES				=	None
 * PREPARED_BY			=	arpit_000
 * REVIEWED_BY			=	
 * REVIEW_DATE			=	dd/mm/yyyy
 * END_OF_TEST_HEADER
 * </PRE>
 */
public class TEST_PROPERTIES_FILE_READER extends Test implements TestExecutor {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, TEST_PROPERTIES_FILE_READER.class, "arpit_000", "26/09/2016", "");
	}

	protected void execute(TestContext context) throws Exception {

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