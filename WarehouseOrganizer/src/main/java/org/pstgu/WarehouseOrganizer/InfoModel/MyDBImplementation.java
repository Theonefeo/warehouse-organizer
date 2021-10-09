package org.pstgu.WarehouseOrganizer.InfoModel;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDBImplementation implements MyDB {
	Logger log = Logger.getLogger(MyDBImplementation.class.getName());

	@Override
	public void addProduct(Product product) {
		// TODO 
		log.log(Level.INFO, "had ADDED product with id = " + product.getName());
	}

	@Override
	public Product getProduct(String name) {
		// TODO
		return new Product("potato", "1kg");
	}

	@Override
	public void deleleteProduct(String name) {
		// TODO
		log.log(Level.INFO, "had DELETED product with id = " + name);
	}

	@Override
	public void editProduct(String name, Product newProduct) {
		// TODO
		log.log(Level.INFO, "had EDITED product with id = " + name);
	}

	@Override
	public void addIngredient(Ingredient ingredient, Dish toDish) {
		// TODO
		log.log(Level.INFO, "had ADDED ingredient to dish");
	}

}
