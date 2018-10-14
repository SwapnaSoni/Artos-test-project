package com.artos.tests.utils_guard;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "13/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0)
public class Test_Byte implements TestExecutable {

	@Override public void execute(TestContext context, Object data1, Object data2) throws Exception {

		// --------------------------------------------------------------------------------------------
//		Guard.guardEquals(context, "Test isEqual() works", true, Guard.isEquals((byte) 0x01, (byte) 0x01));
//		Guard.guardEquals(context, "Test isEqual() works", true, Guard.isEquals((byte) 0xFF, (byte) 0xFF));
//		Guard.guardEquals(context, "Test isEqual() works", true, Guard.isEquals((byte) 0x00, (byte) 0x00));
//		Guard.guardEquals(context, "Test isEqual() works", false, Guard.isEquals((byte) 0x01, (byte) 0x02));
//
//		Guard.guardEquals(context, "Test guardEquals() works", (byte) 0x00, (byte) 0x00);
//		Guard.guardEquals(context, "Test guardEquals() works", (byte) 0x01, (byte) 0x01);
//		Guard.guardEquals(context, "Test guardEquals() works", (byte) 0xFF, (byte) 0xFF);
//		try {
//			Guard.guardEquals(context, "Test guardEquals() works", (byte) 0xFA, (byte) 0xFF);
//			Guard.guardWrongFlow("Did not expect to reach here");
//		} catch (Exception e) {
//			Guard.guardEquals(context, e, "Test guardEquals() works values are not equal");
//		}
//
//		Guard.guardEquals(context, "Test guardEquals() works", (byte) 0xFE, (byte) 0xFF, (byte) 0x05);
//		Guard.guardEquals(context, "Test guardEquals() works", (byte) 0x00, (byte) 0x05, (byte) 0x05);
//		try {
//			Guard.guardEquals(context, "Test guardEquals() works", (byte) 0xFA, (byte) 0xFF, (byte) 0x02);
//			Guard.guardWrongFlow("Did not expect to reach here");
//		} catch (Exception e) {
//			Guard.guardEquals(context, e, "Test guardEquals() works values are not equal");
//		}
//
//		Guard.guardNotEquals(context, "Test guardEquals() works", (byte) 0x00, (byte) 0x01);
//		Guard.guardNotEquals(context, "Test guardEquals() works", (byte) 0x01, (byte) 0xFF);
//		try {
//			Guard.guardNotEquals(context, "Test guardEquals() works", (byte) 0xFF, (byte) 0xFF);
//			Guard.guardWrongFlow("Did not expect to reach here");
//		} catch (Exception e) {
//			Guard.guardEquals(context, e, "Test guardEquals() works values are equal");
//		}
		
		Guard.guardEquals((byte)0xFF, (byte)0xFD, (byte)0x02);
		// --------------------------------------------------------------------------------------------

	}
}
