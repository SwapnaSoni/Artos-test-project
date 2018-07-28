package unit_test.Convert;

import com.arpitos.annotation.TestCase;
import com.arpitos.annotation.TestPlan;
import com.arpitos.framework.infra.TestContext;
import com.arpitos.interfaces.TestExecutable;
import com.arpitos.utils.Convert;
import com.arpitos.utils.Guardian;

@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "3/05/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_concat implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		Convert _con = new Convert();

		{
			byte[] test1 = new byte[] { 0, 1, 2, 3, 4 };
			byte[] test2 = new byte[] { 5, 6, 7, 8 };
			byte[] test3 = new byte[] { 9 };
			byte[] test4 = new byte[] { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, (byte) 255 };
			byte[] expectedResult = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, (byte) 255 };
			byte[] resultArray = _con.concat(test1, test2, test3, test4);
			Guardian.guardEquals("Concatenated Byte Array", expectedResult, resultArray);
		}

		{
			byte test5 = 1;
			byte test6 = 10;
			byte test7 = (byte) 255;
			byte test8 = 0;
			byte[] expectedResult1 = new byte[] { 1, 10, (byte) 255, 0 };
			byte[] resultArray1 = _con.concat(test5, test6, test7, test8);
			Guardian.guardEquals("Concatenated Byte Array", expectedResult1, resultArray1);
		}

		{
			byte[] test9 = { 0, 1, 2, 10, (byte) 255 };
			byte test10 = 10;
			byte test11 = (byte) 255;
			byte test12 = 0;
			byte[] expectedResult2 = new byte[] { 0, 1, 2, 10, (byte) 255, 10, (byte) 255, 0 };
			byte[] resultArray2 = _con.concat(test9, test10, test11, test12);
			Guardian.guardEquals("Concatenated Byte Array", expectedResult2, resultArray2);
		}
		// --------------------------------------------------------------------------------------------

	}
}
