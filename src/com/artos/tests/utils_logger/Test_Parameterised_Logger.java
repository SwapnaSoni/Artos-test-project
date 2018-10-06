package com.artos.tests.utils_logger;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.LogWrapper;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "22/07/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 3)
public class Test_Parameterised_Logger implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		LogWrapper logger = context.getLogger();
		// Single line
		logger.info("Hey How are you");
		// Single line + Integer
		logger.info("Hey How are you" + 1);
		// Single line + unreferenced parameters
		logger.info("Hey How are you" + 1, "Arpit", "Test");
		// Single line + referenced parameters
		logger.info("Hey How {} are you {}" + 1, "Arpit", "Test");
		// Single line + byte Array
		logger.info("Hi How are you" + new Byte[] {});
		// int only
		logger.info(123);
		// long only
		logger.info(1234567891234L);
		// long only
		logger.info((byte) 0x01);
		// Exception
		logger.info(new Exception("Hi"));
		// Throwable
		logger.info(new Throwable("Hi"));
		// --------------------------------------------------------------------------------------------

	}
}
