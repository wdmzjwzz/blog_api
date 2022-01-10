package com.wzz.controller;

import com.wzz.entity.User;
import com.wzz.service.UserService;
import com.wzz.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.UUID;


@RequestMapping("/api/user")
@RestController
//@ControllerAdvice
@Api(value = "user")
public class UserController {

    @ExceptionHandler(Exception.class) //表示让Spring捕获到所有抛出的SignException异常，并交由这个被注解的方法处理。
    @ResponseStatus(HttpStatus.BAD_REQUEST)
        //表示设置状态码。
    String handleException() {
        return "Exception Deal!";
    }

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ApiOperation(value = "注册用户", notes = "注册用户")
    public ResponseResult regist(@RequestBody Map<String,String> params) {
        User user = new User();
        String uuid = UUID.randomUUID().toString().replaceAll("-","").substring(0,8);
        user.setUserName(params.get("userName"));
        user.setPassword(params.get("password"));
        user.setUserId(uuid);
        return ResponseResult.ok(userService.regist(user));
    }


    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录", notes = "注册用户")
    public ResponseResult login(@RequestBody Map<String,String> params) {

        return ResponseResult.ok(userService.login(params.get("userName"),params.get("password")));
    }

}