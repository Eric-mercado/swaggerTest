package com.erik.test.swaggerdemo.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rest/Hello")
@Api(value = "Hello Resource", description = "shows a hello greeting")
public class HelloResource {

    @ApiOperation(value = "Returns Hello World")
    @ApiResponses(
            value= {
                    @ApiResponse(code = 100, message = "100 us the message"),
                    @ApiResponse(code = 200 , message ="successful Hello World  ")
            }
    )
    @GetMapping
    public String getHello(){
        return "Hello World";
    }

    @ApiOperation(value = "Returns Hello World")
    @PostMapping("/add")
    public String helloPost(@RequestBody final String hello){
        return hello;
    }

    @ApiOperation(value = "Returns Hello World")
    @PutMapping("/put")
    public String helloPut(@RequestBody final String hello){
        return hello;
    }
}
