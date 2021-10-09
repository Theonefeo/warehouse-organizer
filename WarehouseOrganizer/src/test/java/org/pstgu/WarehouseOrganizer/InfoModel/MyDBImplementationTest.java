package org.pstgu.WarehouseOrganizer.InfoModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class MyDBImplementationTest {
	MyDB myDB = MyDBConnectionFactory.getConnection();

	@Test
	@DisplayName("Falling test 😎")
	void test(TestInfo testInfo) {
		assertEquals("My 1st JUnit 5 test! 😎", testInfo.getDisplayName(), () -> "TestInfo is injected correctly");
		fail("Not yet implemented");
	}

	@Test
	@DisplayName("Test for getProduct(int id)")
	void getProductTest() {

		assertEquals(new Product("potato", "1kg"), myDB.getProduct("potato"), "not equal");
		assertEquals(new Product("potato", "2kg"), myDB.getProduct("potato"), "not equal");
	}

	@Test
	@DisplayName("Test for MyDB interface")
	void myDBtest() {
		String productName = "potato";
		Product p = new Product(productName, "1kg");
		myDB.addProduct(p);
		assertEquals(p, myDB.getProduct(productName), "not equal");
		myDB.deleleteProduct(productName);

		myDB.addProduct(p);
		myDB.editProduct(productName, new Product(productName, "5kg"));

		assertEquals(new Product("potato", "5kg"), myDB.getProduct(productName), "not equal");
	}

}
