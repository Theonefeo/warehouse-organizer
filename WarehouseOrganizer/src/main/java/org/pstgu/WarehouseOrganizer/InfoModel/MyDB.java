package org.pstgu.WarehouseOrganizer.InfoModel;

import java.util.List;

public interface MyDB {

	public boolean addProduct(Product product);
	
	public Product getProduct(String name);
	
	public List<Product> getAllProducts();

	public Product deleleteProduct(String name);

	public boolean editProduct(String name, Product newProduct);

	public boolean addDish(Dish dish);
	
	public Dish getDish(String name);
	
	public Dish deleteDish(String name);
	
	public boolean addIngredient(Dish toDish, Ingredient ingredient);
	
	public List<Ingredient> getIngedients(String dishName);
	
	public List<Dish> getAllDishes();
}
