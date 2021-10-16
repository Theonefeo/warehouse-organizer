package org.pstgu.WarehouseOrganizer.InfoModel;

import java.sql.SQLException;
import java.util.List;

/**
 * Интерфейс хранения модели в БД
 * @author feodor
 *
 */
public interface MyDB {
	
	public boolean addProduct(String name, String measureUnit);
	
	public Product getProduct(String name) throws NotFoundException, SQLException;
	
	public List<Product> getAllProducts();
	
	public Product deleteProduct(String name) throws NotFoundException, SQLException;

	default public boolean addProduct(Product product) {
		return addProduct(product.getName(),product.getMeasureUnit());
	}
}
