package com.artos.tests.exception;

import java.nio.BufferUnderflowException;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@ExpectedException(expectedExceptions = { BufferUnderflowException.class, NumberFormatException.class, NullPointerException.class }, contains = "abc")
@TestPlan(decription = "", preparedBy = "arpit", preparationDate = "1/10/2018", reviewedBy = "", reviewDate = "")
@TestCase(skip = false, sequence = 0, label = "all")
public class Test_More_Than_one_Exception2 implements TestExecutable {

	public void execute(TestContext context) throws Exception {

		// --------------------------------------------------------------------------------------------
		throw new Exception("abc");
		// --------------------------------------------------------------------------------------------

	}
}
