package com.example.news.controller;

import com.example.news.results.Result;
import com.example.news.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService= new UserService();
    @ApiOperation(value = "login", notes = "login", response = Result.class)
    @PostMapping(value = "/login/")
    public Result login(@ApiParam(value = "username" ,required=true ) @RequestParam String username,
                        @ApiParam(value = "password" ,required=true ) @RequestParam String password){
        return userService.findUserR(username,password);
    }
    @ApiOperation(value = "adduser", notes = "add", response = Result.class)
    @PostMapping(value = "/add/")
    public Result adduser(@ApiParam(value = "username" ,required=true ) @RequestParam String username,
                          @ApiParam(value = "password" ,required=true ) @RequestParam String password){
        return userService.addUser(username,password);
    }

}
