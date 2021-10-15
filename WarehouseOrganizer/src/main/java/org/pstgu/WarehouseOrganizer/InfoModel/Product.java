package org.pstgu.WarehouseOrganizer.InfoModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = false, exclude = { "id" })
public @Data class Product {

	private int id = -1;
	@NonNull
	private String name;
	@NonNull
	private String measureUnit;

	public Product(int id, @NonNull String name, @NonNull String measureUnit) {
		this.id = id;
		this.name = name;
		this.measureUnit = measureUnit;
	}

	public Product(@NonNull String name, @NonNull String measureUnit) {
		this.name = name;
		this.measureUnit = measureUnit;
	}

}
