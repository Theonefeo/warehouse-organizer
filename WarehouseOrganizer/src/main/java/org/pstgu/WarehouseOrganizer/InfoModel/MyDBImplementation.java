package org.pstgu.WarehouseOrganizer.InfoModel;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDBImplementation implements MyDB {
	Logger log = Logger.getLogger(MyDBImplementation.class.getName());

	@Override
	public boolean addProduct(Product product) {
		// TODO 
		log.log(Level.INFO, "had ADDED product with id = " + product.getName());
		return true;
	}

	@Override
	public Product getProduct(String name) {
		// TODO
		return new Product("potato", "1kg");
	}

	@Override
	public Product deleleteProduct(String name) {
		// TODO
		log.log(Level.INFO, "had DELETED product with id = " + name);
		return new Product("potato", "1kg");
	}

	@Override
	public boolean editProduct(String name, Product newProduct) {
		// TODO
		log.log(Level.INFO, "had EDITED product with id = " + name);
		return true;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addDish(Dish dish) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dish getDish(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dish deleteDish(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addIngredient(Dish toDish, Ingredient ingredient) {
		log.log(Level.INFO, "had ADDED ingredient to dish");
		return true;
	}

	@Override
	public List<Ingredient> getIngedients(String dishName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dish> getAllDishes() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
