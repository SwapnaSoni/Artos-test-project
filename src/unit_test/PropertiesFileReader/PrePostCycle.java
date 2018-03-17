package unit_test.PropertiesFileReader;

import org.apache.logging.log4j.Logger;

import com.arpitos.infra.TestContext;
import com.arpitos.interfaces.PrePostRunnable;


public class PrePostCycle implements PrePostRunnable {

	@Override
	public void preTest(TestContext context) throws Exception {
		Logger logger = context.getLogger();
		logger.info(".........................................................................");

		//--------------------------------------------------------------------------------------------
		//TODO Write Code Here
		logger.info("This runs pre each test execution");
		//--------------------------------------------------------------------------------------------

		logger.info(".........................................................................");
	}

	@Override
	public void postTest(TestContext context) throws Exception {
		Logger logger = context.getLogger();
		logger.info(".........................................................................");

		//--------------------------------------------------------------------------------------------
		//TODO Write Code Here
		logger.info("This runs post each test execution");
		//--------------------------------------------------------------------------------------------

		logger.info(".........................................................................");
	}

	@Override
	public void Init(TestContext context) throws Exception {
		Logger logger = context.getLogger();
		logger.info(".........................................................................");

		//--------------------------------------------------------------------------------------------
		//TODO Write Code Here
		logger.info("This runs at the start of testsuit execution");
		//--------------------------------------------------------------------------------------------

		logger.info(".........................................................................");
	}

	@Override
	public void Cleanup(TestContext context) throws Exception {
		Logger logger = context.getLogger();
		logger.info(".........................................................................");

		//--------------------------------------------------------------------------------------------
		//TODO Write Code Here
		logger.info("This runs at the end of testsuit execution");
		//--------------------------------------------------------------------------------------------

		logger.info(".........................................................................");
	}
}