package com.artos.tests.externallistener;

import java.io.File;

import com.artos.framework.Enums.TestStatus;
import com.artos.framework.FWStaticStore;
import com.artos.framework.infra.BDDScenario;
import com.artos.framework.infra.BDDStep;
import com.artos.framework.infra.TestObjectWrapper;
import com.artos.framework.infra.TestUnitObjectWrapper;
import com.artos.interfaces.TestProgress;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CustomListener implements TestProgress {

	@Override
	public void testExecutionLoopCount(int count) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeTestSuiteMethodExecutionStarted(String methodName, String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeTestSuiteMethodExecutionFinished(String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testSuiteExecutionStarted(String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testSuiteExecutionFinished(String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterTestSuiteMethodExecutionStarted(String methodName, String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterTestSuiteMethodExecutionFinished(String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printTestPlan(TestObjectWrapper t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printTestPlan(BDDScenario sc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printTestUnitPlan(TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printTestUnitPlan(BDDStep step) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalBeforeTestUnitMethodExecutionStarted(String methodName, TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalBeforeTestUnitMethodExecutionStarted(String methodName, BDDStep step) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalBeforeTestUnitMethodExecutionFinished(TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalBeforeTestUnitMethodExecutionFinished(BDDStep step) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalAfterTestUnitMethodExecutionStarted(String methodName, TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalAfterTestUnitMethodExecutionStarted(String methodName, BDDStep step) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalAfterTestUnitMethodExecutionFinished(TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalAfterTestUnitMethodExecutionFinished(BDDStep step) {
		// TODO Auto-generated method stub

	}

	@Override
	public void localBeforeTestUnitMethodExecutionStarted(TestObjectWrapper t, TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void localBeforeTestUnitMethodExecutionFinished(TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void localAfterTestUnitMethodExecutionStarted(TestObjectWrapper t, TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void localAfterTestUnitMethodExecutionFinished(TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalBeforeTestCaseMethodExecutionStarted(String methodName, TestObjectWrapper t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalBeforeTestCaseMethodExecutionStarted(String methodName, BDDScenario scenario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalBeforeTestCaseMethodExecutionFinished(TestObjectWrapper t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalBeforeTestCaseMethodExecutionFinished(BDDScenario scenario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalAfterTestCaseMethodExecutionStarted(String methodName, TestObjectWrapper t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalAfterTestCaseMethodExecutionStarted(String methodName, BDDScenario scenario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalAfterTestCaseMethodExecutionFinished(TestObjectWrapper t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void globalAfterTestCaseMethodExecutionFinished(BDDScenario scenario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void localBeforeTestCaseMethodExecutionStarted(String methodName, TestObjectWrapper t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void localBeforeTestCaseMethodExecutionFinished(TestObjectWrapper t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void localAfterTestCaseMethodExecutionStarted(String methodName, TestObjectWrapper t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void localAfterTestCaseMethodExecutionFinished(TestObjectWrapper t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testCaseExecutionStarted(TestObjectWrapper t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testCaseExecutionStarted(BDDScenario scenario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testCaseExecutionFinished(TestObjectWrapper t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testCaseExecutionFinished(BDDScenario scenario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testUnitExecutionStarted(TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testUnitExecutionStarted(BDDStep step) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testUnitExecutionFinished(TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testUnitExecutionFinished(BDDStep step) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testCaseExecutionSkipped(TestObjectWrapper t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void childTestCaseExecutionStarted(TestObjectWrapper t, String paramInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void childTestCaseExecutionStarted(BDDScenario scenario, String paramInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void childTestCaseExecutionFinished(TestObjectWrapper t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void childTestCaseExecutionFinished(BDDScenario scenario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void childTestUnitExecutionStarted(TestObjectWrapper t, TestUnitObjectWrapper unit, String paramInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void childTestUnitExecutionStarted(BDDScenario scenario, BDDStep step, String paramInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void childTestUnitExecutionFinished(TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void childTestUnitExecutionFinished(BDDStep step) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testCaseStatusUpdate(TestStatus testStatus, File snapshot, String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testCaseSummaryPrinting(String FQCN, String description) {
		System.err.println(FQCN + description);
		try {
			writeToExcel(FQCN, description);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public void testUnitSummaryPrinting(String FQCN, String description) {

	}

	@Override
	public void testSuiteSummaryPrinting(String description) {
		System.err.println(description);
	}

	@Override
	public void testSuiteFailureHighlight(String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testSuiteException(String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testException(String description) {
		// TODO Auto-generated method stub

	}

	/**
	 * Create excel sheet to add test summary
	 * 
	 * @param
	 */
	private void createExcelFile() throws Exception {
		try {
			File excelReport = new File(FWStaticStore.LOG_BASE_DIR + "RegressionReport.xls");
			WritableWorkbook wb = Workbook.createWorkbook(excelReport);
			WritableSheet sheet = wb.createSheet("Sheet1", 0);
			jxl.write.Label label1;
			// if (t.getTestOutcomeList().get(0) == TestStatus.FAIL) {
			// Label(column, row, s, timesBoldUnderline);
			label1 = new jxl.write.Label(0, 0, "Suite Name");
			sheet.addCell(label1);

			label1 = new jxl.write.Label(1, 0, "Test Case");
			sheet.addCell(label1);

			label1 = new jxl.write.Label(2, 0, "Test Status");
			sheet.addCell(label1);

			label1 = new jxl.write.Label(3, 0, "Execution Time");
			sheet.addCell(label1);

			label1 = new jxl.write.Label(4, 0, "Jira Reference");
			sheet.addCell(label1);

			label1 = new jxl.write.Label(5, 0, "Execution Date");
			sheet.addCell(label1);

			label1 = new jxl.write.Label(6, 0, "Time");
			sheet.addCell(label1);

			wb.write();
			wb.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	/**
	 * Append test summary to Regression Report
	 * 
	 * @param status Test status
	 * @param testUnitName Name of test unit
	 * @param testTime test execution time
	 * @param jiraRef Jira reference
	 * @param testDuration date and time of execution
	 * 
	 */
	private void writeToExcel(String FQCN, String Description) throws Exception {

		String status = Description.substring(0, 4);
		String testName = Description.substring(7, 108);
		String duration = Description.substring(139, 28);
		File excelReport = new File(FWStaticStore.LOG_BASE_DIR + "RegressionReport.xls");
		if (!excelReport.exists()) {
			try {
				createExcelFile();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

		try {
			Workbook wb = Workbook.getWorkbook(new File(FWStaticStore.LOG_BASE_DIR + "RegressionReport.xls"));
			WritableWorkbook sheet = Workbook.createWorkbook(excelReport, wb);
			WritableSheet workSheet = sheet.getSheet("Sheet1");
			// Test Unit name "Test Case" Test Status "Execution Time" Jiraref date time

			jxl.write.Label label1;
			int i = workSheet.getRows();

			// Label(column, row, s, timesBoldUnderline);
			label1 = new jxl.write.Label(0, i, testName);
			workSheet.addCell(label1);
			label1 = new jxl.write.Label(1, i, testName);
			workSheet.addCell(label1);
			label1 = new jxl.write.Label(2, i, status);
			workSheet.addCell(label1);
			label1 = new jxl.write.Label(3, i, duration);
			workSheet.addCell(label1);
			//
			// label1 = new jxl.write.Label(4, i, jiraRef);
			// workSheet.addCell(label1);
			//
			// String startTimeStamp = new Transform().MilliSecondsToFormattedDate("dd-MM-yyyy hh:mm:ss", getTestSuiteStartTime());
			// String[] startDate = startTimeStamp.split(" ");
			// label1 = new jxl.write.Label(5, i, startDate[0]);
			// workSheet.addCell(label1);

			// label1 = new jxl.write.Label(6, i, startDate[1]);
			// workSheet.addCell(label1);
			sheet.write();
			sheet.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public void globalAfterFailedUnitMethodExecutionStarted(String methodName, TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void globalAfterFailedUnitMethodExecutionStarted(String methodName, BDDStep step) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void globalAfterFailedUnitMethodExecutionFinished(TestUnitObjectWrapper unit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void globalAfterFailedUnitMethodExecutionFinished(BDDStep step) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testResult(TestObjectWrapper t, TestStatus testStatus, File snapshot, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testResult(BDDScenario scenario, TestStatus testStatus, File snapshot, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testUnitResult(TestUnitObjectWrapper unit, TestStatus testStatus, File snapshot, String description) {
		// TODO Auto-generated method stub
		
	}

}
