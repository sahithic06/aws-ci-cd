package com.cisco.code.aws.myapp.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "host")
public class Host {

	@Id
	private String id;
	public String ipAddress;
	public String db;

	public Host() {
	}

	public Host(String host, String db) {
		super();
		this.ipAddress = host;
		this.db = db;
	}


	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%s, host='%s', db='%s']", ipAddress, db);
	}

}