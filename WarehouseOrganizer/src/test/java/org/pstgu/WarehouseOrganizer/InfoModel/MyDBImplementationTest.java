package org.pstgu.WarehouseOrganizer.InfoModel;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

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
	@DisplayName("Test for MyDB Product interface")
	void myDBtest() {
		Product[] products = { new Product("Картофель", "кг"), new Product("Сгущенка", "банка"),
				new Product("Скумбрия", "консерва"), new Product("Сахар", "кг"),
				new Product("Грецкие орехи", "пачка 300г"), new Product("Чай", "пачка 100 г"),
				new Product("Соль", "пачка 1,5кг"), new Product("Капуста", "головка"), new Product("Яблоки", "шт"),
				new Product("Кукуруза", "банка") };

		for (Product product : products) {
			myDB.addProduct(product);
		}
		System.out.println(myDB.getAllProducts());

		for (Product product : products) {
			assertDoesNotThrow(() -> myDB.getProduct(product.getName()), "getProduct throws Exception");
			Product p = null;
			try {
				p = myDB.deleteProduct(product.getName());
			} catch (NotFoundException | SQLException e) {
				e.printStackTrace();
			} finally {
				assertEquals(product, p, "not equal");
			}
		}

		System.out.println(myDB.getAllProducts());

	}

}
