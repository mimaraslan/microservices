package com.mimaraslan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mimaraslan.service.SchoolService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class SchoolController {
	
	@Autowired
	SchoolService studentService;

	
	// http://localhost:8015/getSchoolDetails/school1
	
	//@RequestMapping(value = "/getSchoolDetails/{schoolname}", method = RequestMethod.GET)
	@GetMapping(value = "/getSchoolDetails/{schoolname}")
	public String getStudents(@PathVariable String schoolname) {
		System.out.println("Going to call student service to get data!");
		return studentService.callStudentServiceAndGetData(schoolname);
	}
	
	
	// http://localhost:8015/test1/school1
		
	@RequestMapping(value = "/test1/{schoolname}", method = RequestMethod.GET)
	public String getStudents1(@PathVariable String schoolname) {
		System.out.println("test1 Going to call student service to get data!");
		return studentService.test1(schoolname);
	}
	
	// http://localhost:8015/test2/school1

	@RequestMapping(value = "/test2/{schoolname}", method = RequestMethod.GET)
	public String getStudents2(@PathVariable String schoolname) {
		System.out.println("test2 Going to call student service to get data!");
		return studentService.test2(schoolname);
	}
	
//-----------------------------------------------------------------	
	@RequestMapping(value = "/")
	   @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
	      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
	   })
	   public String hello() throws InterruptedException {
	      Thread.sleep(3000);
	      return "Welcome Hystrix";
	   }
	   private String fallback_hello() {
	      return "Request fails. It takes long time to response";
	   }

}