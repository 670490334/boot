package com.rabbit.chshady.swagger.swaggerdemo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 廖凡
 * @Date 2019/12/25 17:09
 */
@Api(tags = "SwaggerController", description = "SwaggerDemo接口")
@RestController
@RequestMapping("swagger")
public class SwaggerController {

    @ApiOperation("获取你好")
    @GetMapping("login")
    public String get(@RequestParam("id") String id, @RequestParam(defaultValue = "1") int startPage, @RequestParam(defaultValue = "5") int size){
        return "你好";
    }

    @ApiOperation("注册")
    @PostMapping("/registry")
    public String post(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("tel") String tel){
        return "username : "+username+"/n password "+password;
    }
}
