package com.artos.tests.utils_imagecompare;

import java.io.File;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.exception.ValueNotAsExpectedException;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;
import com.artos.utils.ImageCompare;

@TestPlan(preparedBy = "arpit", preparationDate = "25/08/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase
public class image_compare implements TestExecutable {

	@Unit
	public void testUnit_1(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		File eyeJPG = new File("./assets/images/eye.jpg");
		File eyeJPG_Modified = new File("./assets/images/eye_modified.jpg");
		File eyeJPG_Modified_large = new File("./assets/images/eye_modified_large.jpg");
		File testPNG = new File("./assets/images/test.png");
		File testPNG_Modified = new File("./assets/images/test_modified.png");
		ImageCompare ic = new ImageCompare();

		// Compare with same JPG image
		ic.compare(eyeJPG, eyeJPG);
		Guard.guardEquals(100, ic.getPercentageMatch());
		// Compare with same PNG image
		ic.compare(testPNG, testPNG);
		Guard.guardEquals(100, ic.getPercentageMatch());

		// Compare with JPG with PNG image
		try {
			ic.compare(eyeJPG, testPNG);
			Guard.guardEquals(100, ic.getPercentageMatch());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Compare with modified image
		ic.compare(eyeJPG, eyeJPG_Modified);
		Guard.guardEquals(84, ic.getPercentageMatch());

		// Compare with modified image
		ic.compare(testPNG, testPNG_Modified);
		Guard.guardEquals(99, ic.getPercentageMatch());

		// Confirm test image is being generated
		ic.compare(testPNG, testPNG_Modified, new File("./reporting/"), "result_png");
		if (!new File("./reporting/result_png.png").exists()) {
			throw new Exception("Test Fail. Result PNG is not generated");
		}
		// Compare with modified image
		ic.compare(eyeJPG, eyeJPG_Modified, new File("./reporting/"), "result_jpg");
		if (!new File("./reporting/result_jpg.jpg").exists()) {
			throw new Exception("Test Fail. Result PNG is not generated");
		}
		// Compare with modified large image
		ic.compare(eyeJPG, eyeJPG_Modified_large, new File("./reporting/"), "result_jpg_large");
		if (!new File("./reporting/result_jpg_large.jpg").exists()) {
			throw new Exception("Test Fail. Result PNG is not generated");
		}
		// --------------------------------------------------------------------------------------------
	}

}
