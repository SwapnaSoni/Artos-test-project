package com.artos.tests.annotation_dataprovider;

public class DataProvider {

	// --------------------------------------------------------------------------------------
	// Static Methods
	// --------------------------------------------------------------------------------------
	@com.artos.annotation.DataProvider(name = "StaticUserNamesStringString")
	public static Object[][] staticStringString() {
		return new Object[][] { { "Static_testuser_1", "Test@123" }, { "Static_testuser_2", "Test@456" } };
	}

	// --------------------------------------------------------------------------------------
	// Non Static Methods
	// --------------------------------------------------------------------------------------
	@com.artos.annotation.DataProvider(name = "NonStaticUserNamesStringString")
	public static Object[][] nonStaticStringString() {
		return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_2", "Test@456" } };
	}

	@com.artos.annotation.DataProvider(name = "NonStaticUserNamesStringInteger")
	public Object[][] nonStaticStringInteger() {
		return new Object[][] { { "testuser_1", 1 }, { "testuser_2", 2 } };
	}

	@com.artos.annotation.DataProvider(name = "NonStaticUserNamesIntegerString")
	public Object[][] nonStaticIntegerString() {
		return new Object[][] { { 1, "Test@123" }, { 2, "Test@456" } };
	}

	@com.artos.annotation.DataProvider(name = "NonStaticUserNamesIntegerString")
	public Object[][] nonStaticStringByteArray() {
		return new Object[][] { { 1, new byte[] { 1, 2, 3, 4 } }, { 2, new byte[] { 5, 6, 7, 8 } } };
	}

	// --------------------------------------------------------------------------------------
	// Non Static Same Name
	// --------------------------------------------------------------------------------------
	@com.artos.annotation.DataProvider(name = "NON_STATIC_STRING_STRING")
	public static Object[][] nonStaticStringString1() {
		return new Object[][] { { "capital_1", "Test@123" }, { "capital_2", "Test@456" } };
	}

	// --------------------------------------------------------------------------------------
	// Non Static Bad Path
	// --------------------------------------------------------------------------------------
	@com.artos.annotation.DataProvider(name = "NonStaticUserNamesSingleDimention")
	public Object[][] nonStaticSingleDimentionArray() {
		return new Object[][] { { 1 }, { 2 } };
	}

	@com.artos.annotation.DataProvider(name = "EmptyDataProvider")
	public Object[][] emptyDataProvider() {
		return new Object[][] { {} };
	}

	@com.artos.annotation.DataProvider(name = "NullDataProvider")
	public Object[][] nullDataProvider() {
		return null;
	}
}
