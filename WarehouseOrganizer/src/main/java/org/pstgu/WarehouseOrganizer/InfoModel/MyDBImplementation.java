package org.pstgu.WarehouseOrganizer.InfoModel;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDBImplementation implements MyDB {
	private static class Tester {
		public static void main(String[] args) throws Exception {
			MyDB db = MyDBConnectionFactory.getConnection();
			System.out.println(db.addProduct("tomato", "kg"));

			db.getAllProducts();
		}
	}

	Logger log = Logger.getLogger(getClass().getName());
	Connection connection = null;

	public MyDBImplementation() {
		try {
			// db parameters
			String url = "jdbc:sqlite:src/main/resources/db.sqlite";
			// create a connection to the database
			connection = DriverManager.getConnection(url);

			log.log(Level.INFO, "Connection to SQLite has been established.");

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
			closeConnection();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		closeConnection();
	}

	private void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
				log.log(Level.INFO, "Connection to SQLite has been closed.");
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public boolean addProduct(String name, String measureUnit) {
		try {
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO Product(name, measureUnit) VALUES ('" + name + "', '" + measureUnit + "');";
			int rows = statement.executeUpdate(sql);
			log.log(Level.INFO, String.format("had been ADDED product {%s, %s}", name, measureUnit));
			return true;
		} catch (SQLException e) {
			log.log(Level.INFO, String.format("product {%s, %s} have been already exists", name, measureUnit));
			return false;
		}
	}

	@Override
	public Product getProduct(String name) throws NotFoundException, SQLException {
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM Product WHERE name='" + name + "';";
			ResultSet r = statement.executeQuery(sql);
			if (r.next() == false)
				throw new NotFoundException("Product with name '" + name + "' not found.");

			return new Product(r.getInt(1), r.getString(2), r.getString(3));
		} catch (SQLException e) {
			log.log(Level.WARNING, e.getMessage());
			// TODO
			throw e;
		}
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM Product;";
			ResultSet execResult = statement.executeQuery(sql);
			while (execResult.next()) {
				int id = execResult.getInt(1);
				String name = execResult.getString(2);
				String measureUnit = execResult.getString(3);

				Product p = new Product(id, name, measureUnit);

				list.add(p);
			}
			log.log(Level.INFO, String.format("had been GOT %d product(s)", list.size()));
		} catch (SQLException e) {
			log.log(Level.WARNING, e.getMessage());
		}
		return list;
	}

	@Override
	public Product deleteProduct(String name) throws NotFoundException, SQLException {
		try {
			Statement statement = connection.createStatement();
			Product p = getProduct(name);
			int rows = statement.executeUpdate("DELETE FROM Product WHERE name='" + name + "';");
			log.log(Level.INFO, String.format("had been DELETED %d product with name = %s", rows, name));
			return p;
		} catch (SQLException e) {
			log.log(Level.WARNING, e.getMessage());
			// TODO
			throw e;
		}
	}

}
