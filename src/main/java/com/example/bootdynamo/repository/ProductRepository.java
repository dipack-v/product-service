package com.example.bootdynamo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

@Repository
public class ProductRepository {
	
	private final DynamoDBMapper mapper;


	public ProductRepository(AmazonDynamoDB amazonDynamoDB) {
		super();
		this.mapper = new DynamoDBMapper(amazonDynamoDB);
	}
	
	public List<Product> findAll(){
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		return mapper.scan(Product.class, scanExpression);
	}
	
}
