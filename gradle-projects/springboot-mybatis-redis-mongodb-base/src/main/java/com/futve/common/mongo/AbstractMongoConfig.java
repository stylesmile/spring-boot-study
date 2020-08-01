//package com.futve.common.mongo.mongoconfig;
//
//import com.mongodb.*;
//import lombok.Data;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 根据配置文件创建MongoDbFactory
// *
// * @author congpeng
// *
// */
//@Data
//public abstract class AbstractMongoConfig {
//
//	private String host;
//	private String database;
//	private String username;
//	private String password;
//	private int port;
//
//	/**
//	 * Method that creates MongoDbFactory Common to both of the MongoDb connections
//	 */
//	public MongoDbFactory mongoDbFactory() throws Exception {
//
//		ServerAddress serverAddress = new ServerAddress(host, port);
//		List<MongoCredential> mongoCredentialList = new ArrayList<>();
//			mongoCredentialList.add(MongoCredential.createCredential(username, database, password.toCharArray()));
//		MongoClient mongoClient = new MongoClient(serverAddress, mongoCredentialList);
//		return new SimpleMongoDbFactory(mongoClient,database);
//	}
//
//	/**
//	 * Factory method to create the MongoTemplate
//	 */
//	abstract public MongoTemplate getMongoTemplate() throws Exception;
//}
