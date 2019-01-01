package com.example.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.example.demo.iiht.service.AssignmentService;

@RunWith(Suite.class)
	@Suite.SuiteClasses({
	    AssignmentService.class, //test case 1
	})
	public class iihtTestSuite {

	}
