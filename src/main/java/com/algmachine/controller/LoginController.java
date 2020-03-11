package com.algmachine.controller;

import com.algmachine.dto.UserRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

    @ApiOperation(value = "测试登录接口")
    @RequestMapping(value = "/v1.0/test", method = RequestMethod.GET)
    public String loginWeb(@RequestParam("userId") String userId) {

        System.out.println("hello world!" + userId);
        return userId;
    }


    @ApiOperation(value = "测试登录接口")
    @RequestMapping(value = "/v1.0/json/test", method = RequestMethod.POST)
    public String loginWebForJson(@RequestBody UserRequest request) {

        System.out.println("hello world!" + request.getUserId());
        return request.getUserId();
    }
}
