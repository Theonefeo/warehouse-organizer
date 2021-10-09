package org.pstgu.WarehouseOrganizer.InfoModel;

public interface MyDB {

	public void addProduct(Product product);
	
	public Product getProduct(String name);

	public void deleleteProduct(String name);

	public void editProduct(String name, Product newProduct);

	public void addIngredient(Ingredient ingredient, Dish toDish);
}
