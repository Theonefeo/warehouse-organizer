package org.pstgu.WarehouseOrganizer.InfoModel;

public class MyDBConnectionFactory {
	private static MyDB connectionInstance;

	private MyDBConnectionFactory() {
	}

	public static MyDB getConnection() {
		if (connectionInstance == null) {
			connectionInstance = new MyDBImplementation();
		}
		return connectionInstance;
	}
	
	public static MyDB getNewConnection() {
		return new MyDBImplementation();
	}
}
