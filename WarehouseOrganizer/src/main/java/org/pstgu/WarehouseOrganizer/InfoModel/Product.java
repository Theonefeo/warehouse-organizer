package org.pstgu.WarehouseOrganizer.InfoModel;

public class Product {

	private String name;
	private String measureUnit;

	public Product() {
	}

	public Product(String name, String measureUnit) {
		this.name = name;
		this.measureUnit = measureUnit;
	}

	@Override
	public boolean equals(Object obj) {
		Product product = (Product) obj;
		return this.name.equals(product.name) && this.measureUnit.equals(product.measureUnit);
	}

	/*
	 * getters and setters
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}
}
