package unit_test.CustomPrompt;

import java.io.File;
import java.util.concurrent.CountDownLatch;

import com.arpit.framework.Test;
import com.arpit.infra.OrganisedLog;
import com.arpit.infra.OrganisedLog.LOG_LEVEL;
import com.arpit.infra.TestContext;
import com.arpit.interfaces.TestExecutor;
import com.arpit.utils.CustomPrompt;

/***
 * 
 * <PRE>
 * START_OF_TEST_HEADER
 * TEST_TARGET			= 	TEST_COUNTDOWN_TIMER
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
public class TEST_COUNTDOWN_TIMER extends Test implements TestExecutor {

	public void onExecute(TestContext context) throws Exception {
		onExecute(context, TEST_COUNTDOWN_TIMER.class, "arpit_000", "18/09/2016", "");
	}

	protected void execute(TestContext context) throws Exception {

		context.setKnownToFail(false, "");
		// --------------------------------------------------------------------------------------------
		OrganisedLog logger = context.getLogger();
		long time = System.currentTimeMillis();

		// Countdown time blocking
		CountDownLatch cntdwnltch1 = new CountDownLatch(1);
		CustomPrompt cntdwn1 = new CustomPrompt(cntdwnltch1, 5000);
		cntdwn1.setStr1("Countdown Timer : Blocking");
		cntdwn1.setStr2("Button Text override : false");
		cntdwn1.setStr3("Hide Buttons : False");
		cntdwn1.setStr4("Image : Not Provided");
		cntdwn1.Start();
		cntdwnltch1.await();
		logger.println(LOG_LEVEL.DEBUG, Boolean.toString(cntdwn1.isButtonYesPressed()) + " : " + Boolean.toString(cntdwn1.isButtonNoPressed()));

		long time2 = System.currentTimeMillis();
		System.out.println(Long.toString((time2 - time)));

		CountDownLatch cntdwnltch2 = new CountDownLatch(1);
		CustomPrompt cntdwn2 = new CustomPrompt(cntdwnltch2, 5000);
		cntdwn2.setBtnYesText("????");
		cntdwn2.setBtnNoText("****");
		cntdwn2.setStr1("Countdown Timer : Blocking");
		cntdwn2.setStr2("Button Text override : true");
		cntdwn2.setStr3("Hide Buttons : False");
		cntdwn2.setStr4("Image : Not Provided");
		cntdwn2.Start();
		cntdwnltch2.await();
		logger.println(LOG_LEVEL.DEBUG, Boolean.toString(cntdwn2.isButtonYesPressed()) + " : " + Boolean.toString(cntdwn2.isButtonNoPressed()));

		long time3 = System.currentTimeMillis();
		System.out.println(Long.toString((time3 - time)));

		CountDownLatch cntdwnltch3 = new CountDownLatch(1);
		CustomPrompt cntdwn3 = new CustomPrompt(cntdwnltch3, 5000);
		cntdwn3.setStr1("Countdown Timer : Blocking");
		cntdwn3.setStr2("Button Text override : false");
		cntdwn3.setStr3("Hide Buttons : True");
		cntdwn3.setStr4("Image : Not Provided");
		cntdwn3.setHideButtons(true);
		cntdwn3.Start();
		cntdwnltch3.await();
		logger.println(LOG_LEVEL.DEBUG, Boolean.toString(cntdwn3.isButtonYesPressed()) + " : " + Boolean.toString(cntdwn3.isButtonNoPressed()));

		long time4 = System.currentTimeMillis();
		System.out.println(Long.toString((time4 - time)));

		CountDownLatch cntdwnltch4 = new CountDownLatch(1);
		CustomPrompt cntdwn4 = new CustomPrompt(cntdwnltch4, 5000);
		cntdwn4.showImage(new File("./assets/images/eye.png"));
		cntdwn4.setStr1("Countdown Timer : Blocking");
		cntdwn4.setStr2("Button Text override : false");
		cntdwn4.setStr3("Hide Buttons : True");
		cntdwn4.setStr4("Image : Provided");
		cntdwn4.Start();
		cntdwnltch4.await();
		logger.println(LOG_LEVEL.DEBUG, Boolean.toString(cntdwn4.isButtonYesPressed()) + " : " + Boolean.toString(cntdwn4.isButtonNoPressed()));

		long timelast = System.currentTimeMillis();
		System.out.println(Long.toString((timelast - time)));
		CountDownLatch cntdwnltch5 = new CountDownLatch(1);
		CustomPrompt cntdwn5 = new CustomPrompt(cntdwnltch5, 10000);
		cntdwn5.showImage(new File("./assets/images/test.jpg"));
		cntdwn5.setStr1("Countdown Timer : Blocking");
		cntdwn5.setStr2("Stop GUI at anytime");
		cntdwn5.setStr3("");
		cntdwn5.setStr4("");
		cntdwn5.Start();
		Thread.sleep(5000);
		cntdwn5.stop();
		cntdwnltch5.await();
		logger.println(LOG_LEVEL.DEBUG, Boolean.toString(cntdwn5.isButtonYesPressed()) + " : " + Boolean.toString(cntdwn5.isButtonNoPressed()));

		CustomPrompt cntdwn6 = new CustomPrompt(null, 5000);
		cntdwn6.showImage(new File("C:\\Users\\arpit_000\\Desktop\\Arpit\\Arpit_Programming\\Test_Arpitos_Utils\\assets\\images\\eye.png"));
		cntdwn6.setStr1("Countdown Timer : Non-Blocking");
		cntdwn6.setStr2("Non-Blocking timer");
		cntdwn6.setStr3("");
		cntdwn6.setStr4("");
		cntdwn6.Start();
		logger.println(LOG_LEVEL.DEBUG, Boolean.toString(cntdwn6.isButtonYesPressed()) + " : " + Boolean.toString(cntdwn6.isButtonNoPressed()));

		CountDownLatch cntdwnltch7 = new CountDownLatch(1);
		CustomPrompt cntdwn7 = new CustomPrompt(cntdwnltch7, 10000);
		cntdwn7.showImage(new File("C:\\Users\\arpit_000\\Desktop\\Arpit\\Arpit_Programming\\Test_Arpitos_Utils\\assets\\images\\eye.png"));
		cntdwn7.setStr1("Countdown Timer : Non-Blocking");
		cntdwn7.setStr2("Non-Blocking timer");
		cntdwn7.setStr3("");
		cntdwn7.setStr4("");
		cntdwn7.Start();
		cntdwnltch7.await();
		logger.println(LOG_LEVEL.DEBUG, Boolean.toString(cntdwn6.isButtonYesPressed()) + " : " + Boolean.toString(cntdwn6.isButtonNoPressed()));
		logger.println(LOG_LEVEL.DEBUG, Boolean.toString(cntdwn7.isButtonYesPressed()) + " : " + Boolean.toString(cntdwn7.isButtonNoPressed()));
		// --------------------------------------------------------------------------------------------

	}
}