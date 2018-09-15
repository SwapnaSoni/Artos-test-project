package com.artos.tests.transform;

import com.artos.annotation.Group;
import com.artos.annotation.KnownToFail;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;
import com.artos.utils.Transform;

@Group(group = { "CI_AT" })
@KnownToFail(ktf = false, bugref = "JIRA-134, JIRA-456, JIRA-789")
@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "3/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_bytes_to_ascii implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		Transform _tfm = new Transform();

		{
			// public String bytesToStringHex(byte data, boolean bDisplaySize)
			byte[] test1 = { (byte) 0x54, (byte) 0x45, (byte) 0x53, (byte) 0x54 };
			String expectedResult1 = "TEST";
			String resultArray1 = _tfm.bytesToAscii(test1);
			Guard.guardEquals(context, "Bytes To ASCII", expectedResult1, resultArray1);
			context.setTestStatus(TestStatus.PASS, "4 bytes to hex string conversion is successful");
		}

		{
			// public String bytesToAscii(byte data)
			byte test2 = (byte) 0x54;
			String expectedResult2 = "T";
			String resultArray2 = _tfm.bytesToAscii(test2);
			Guard.guardEquals(context, "Byte To ASCII", expectedResult2, resultArray2);
			context.setTestStatus(TestStatus.PASS, "1 bytes to hex string conversion is successful");
		}

		context.getGlobalObject("PARAMETER-1");
		context.setTestStatus(TestStatus.FAIL, "Did not expect to reach here");
		throw new Exception("Before Test Suite");
		// --------------------------------------------------------------------------------------------

	}
}
