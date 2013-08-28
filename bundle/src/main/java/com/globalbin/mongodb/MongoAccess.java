package com.globalbin.mongodb;

import com.globalbin.impl.filters.LoggingFilter;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoAccess {
	
	private String dbName = "itunes";
	private String collectionName = "trackdbs";
	private MongoClient mongoClient = null;
	private DB db = null;
    private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
	
	public void init() {
		try { 
			mongoClient = new MongoClient("localhost", 27017);		
		} catch (UnknownHostException uhe) {
			logger.error("UnknowHostException", uhe);
		}
	}

	public void shutdown() {
		mongoClient.close();
	}
	
	public String getDbInfo() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Databases:\n");
		sb.append("----------\n");
		
		for (String s : mongoClient.getDatabaseNames()) {
		   sb.append(s+"\n");
		}
		
		db = mongoClient.getDB(dbName);
		
		sb.append("\nCollections:");
		sb.append("\n----------\n");
		Set<String> colls = db.getCollectionNames();
		for (String s : colls) {
		    sb.append(s+"\n");
		}
		
		DBCollection coll = db.getCollection(collectionName);
		
		sb.append("\nRecord:");
		sb.append("\n----------\n");
		DBObject myDoc = coll.findOne();
		sb.append(myDoc+"\n");
		
		sb.append("\nCount: " + coll.getCount());
		
		sb.append("\nIndexes:\n");
		sb.append("\n----------\n");
		List<DBObject> list = coll.getIndexInfo();
		for (DBObject o : list) {
		   sb.append(o+"\n");
		}
		return sb.toString();
	}

}
