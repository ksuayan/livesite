package com.globalbin.mongodb;

public class MongoDBClient {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MongoAccess mongoAccess = new MongoAccess();
		mongoAccess.init();
		System.out.println(mongoAccess.getDbInfo());
		mongoAccess.shutdown();
	}

}
