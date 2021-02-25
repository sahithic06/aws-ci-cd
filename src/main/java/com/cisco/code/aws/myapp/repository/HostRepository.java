package com.cisco.code.aws.myapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cisco.code.aws.myapp.pojo.Host;

@Repository
public interface HostRepository extends MongoRepository<Host, String> {

  

}