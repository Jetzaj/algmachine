package com.algmachine.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

    @ApiOperation(value = "测试登录接口")
    @RequestMapping(value = "/v1.0/test", method = RequestMethod.GET)
    public void loginWeb(@RequestParam("userId") String userId) {
        System.out.println("hello world!" + userId);
    }
}
