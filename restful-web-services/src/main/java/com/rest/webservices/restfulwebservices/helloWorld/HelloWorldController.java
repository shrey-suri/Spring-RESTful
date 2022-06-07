package com.rest.webservices.restfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //Using Request Parameter
    @GetMapping("/hello")
    public String helloWorld(@RequestParam (value = "name", defaultValue = "World") String name){
        return "Hello " + name;
    }

    //Using Class Bean
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    //Using Path Variable
    @GetMapping(path = "/hello-world/{name}")
    public String helloWorldPathVariable(@PathVariable String name){
        return String.format("Hello World %s" , name);
    }
}
