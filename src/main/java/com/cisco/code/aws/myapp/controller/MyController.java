package com.cisco.code.aws.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.code.aws.myapp.pojo.Host;
import com.cisco.code.aws.myapp.repository.HostRepository;

@RestController
public class MyController {

	private HostRepository repository;

	public MyController(HostRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping
	public String checkReadiness() {
		return "I am ready!!";
	}

	@GetMapping(value = "echo/{test}")
	public ResponseEntity<String> echoMethod(@PathVariable(value = "test") String test) {
		return new ResponseEntity<>(test, HttpStatus.OK);
	}

	@GetMapping(value = "mongo")
	public ResponseEntity<String> hosts(HttpServletRequest request) {
		String hosts = null;
		for (Host host : repository.findAll()) {
			if (hosts != null) {
				hosts += ", " + host.getIpAddress();
			} else {
				hosts = host.getIpAddress();
			}
		}
		//String addressMessage = "Request recieved from " + request.getRemoteAddr() + ". ";
		if (hosts != null) {
			return new ResponseEntity<>( "Documents are inserted from hosts " + hosts, HttpStatus.OK);
		} else {
			return new ResponseEntity<>( "No documents in db, please insert", HttpStatus.OK);
		}
	}
}
