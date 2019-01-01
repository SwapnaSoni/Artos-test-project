package com.artos.tests.annotation_unit;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "1/01/2019", bdd = "GIVEN unit annotation is used and sequence numbers are provided THEN methods with sequence numbers will be executed in provided sequence order AND methods with same sequence number will be executed in the provided sequence but amond them order of execution can not be guaranteed AND method with no sequence number provided will be assumed to be a sequence number of 0")
@TestCase(skip = false, sequence = 1)
public class PASS_Unit_Same_Sequence_No implements TestExecutable {

	@Unit(sequence = 1)
	public void sequenceTest_1(TestContext context) {
		System.out.println("Same sequence seq : 1");
	}

	@Unit(sequence = 1)
	public void sequenceTest_2(TestContext context) {
		System.out.println("Same sequence seq : 1");
	}

	@Unit(sequence = 1)
	public void sequenceTest_3(TestContext context) {
		System.out.println("Same sequence seq : 1");
	}

	@Unit(sequence = 100)
	public void sequenceTest_100(TestContext context) {
		System.out.println("Same sequence seq : 100");
	}

	@Unit(sequence = 100)
	public void sequenceTest_101(TestContext context) {
		System.out.println("Same sequence seq : 100");
	}

	@Unit(sequence = 100)
	public void sequenceTest_102(TestContext context) {
		System.out.println("Same sequence seq : 100");
	}

	@Unit(sequence = 0)
	public void sequenceTest_200(TestContext context) {
		System.out.println("Same sequence seq : 0");
	}

	@Unit(sequence = 0)
	public void sequenceTest_201(TestContext context) {
		System.out.println("Same sequence seq : 0");
	}

	@Unit(sequence = 0)
	public void sequenceTest_202(TestContext context) {
		System.out.println("Same sequence seq : 0");
	}

	@Unit(sequence = -100)
	public void sequenceTest_300(TestContext context) {
		System.out.println("Same sequence seq : -100");
	}

	@Unit(sequence = -100)
	public void sequenceTest_301(TestContext context) {
		System.out.println("Same sequence seq : -100");
	}

	@Unit(sequence = -100)
	public void sequenceTest_302(TestContext context) {
		System.out.println("Same sequence seq : -100");
	}
}
