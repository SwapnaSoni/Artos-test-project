package unit_test;

import org.apache.logging.log4j.Logger;

import com.arpitos.infra.TestContext;
import com.arpitos.infra.annotation.AfterTest;
import com.arpitos.infra.annotation.AfterTestsuit;
import com.arpitos.infra.annotation.BeforeTest;
import com.arpitos.infra.annotation.BeforeTestsuit;
import com.arpitos.interfaces.PrePostRunnable;


public class PrePostCycle implements PrePostRunnable {

	@Override
	@BeforeTest
	public void beforeTest(TestContext context) throws Exception {
		Logger logger = context.getLogger();
		logger.info(".........................................................................");

		//--------------------------------------------------------------------------------------------
		//TODO Write Code Here
		logger.info("This runs pre each test execution");
		//--------------------------------------------------------------------------------------------

		logger.info(".........................................................................");
	}

	@Override
	@AfterTest
	public void afterTest(TestContext context) throws Exception {
		Logger logger = context.getLogger();
		logger.info(".........................................................................");

		//--------------------------------------------------------------------------------------------
		//TODO Write Code Here
		logger.info("This runs post each test execution");
		//--------------------------------------------------------------------------------------------

		logger.info(".........................................................................");
	}

	@Override
	@BeforeTestsuit
	public void beforeTestsuit(TestContext context) throws Exception {
		Logger logger = context.getLogger();
		logger.info(".........................................................................");

		//--------------------------------------------------------------------------------------------
		//TODO Write Code Here
		logger.info("This runs at the start of testsuit execution");
		//--------------------------------------------------------------------------------------------

		logger.info(".........................................................................");
	}

	@Override
	@AfterTestsuit
	public void afterTestsuit(TestContext context) throws Exception {
		Logger logger = context.getLogger();
		logger.info(".........................................................................");

		//--------------------------------------------------------------------------------------------
		//TODO Write Code Here
		logger.info("This runs at the end of testsuit execution");
		//--------------------------------------------------------------------------------------------

		logger.info(".........................................................................");
	}
}