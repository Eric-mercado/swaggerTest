package com.erik.test.swaggerdemo.resource;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/user")
@Api(value = "User Resource",  description = "shows the user resource")
public class UserResource {

@GetMapping
    public List<User> getUser(){
        return Arrays.asList(
                new User("Peter", 2000L),
                new User("Sam", 2000L)
            );

    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable final String UserName){
        return new User(UserName, 100L );
    }

    private class User{
    @ApiModelProperty(notes= "name of the user")
    private String userName;
    @ApiModelProperty(notes= "income of the user")
    private Long Salary;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Long getSalary() {
            return Salary;
        }

        public void setSalary(Long salary) {
            Salary = salary;
        }

        public User(String userName, Long salary) {
            this.userName = userName;
            Salary = salary;
        }
    }
}
