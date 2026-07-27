package com.in28minutes.springboot.rest_api.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloWorldResource {

	@RequestMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	//returning bean
	@RequestMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello world");
	}
	
	
	//Path variable or Path params
	// users/Ranga/todos/1
	
	@RequestMapping("/hello-world-path-param/{name}")
	public HelloWorldBean helloWorldBeanPathParam(@PathVariable String name) {
		
		
		return new HelloWorldBean("hello world from path variable with name:"+name);
		
		
	}
	
	
	
	@RequestMapping("/hello-world-path-param/{name}/message/{message}")
	public HelloWorldBean helloWorldMultiplePathParam(@PathVariable String name,@PathVariable String message) {
		
		
		return new HelloWorldBean("hello world from path variable with name: "+name+","+message);
		
		
	}
	
}
