package com.rabbit.chshady.securityandjwt.springsecurityjwt.controller;

import com.rabbit.chshady.securityandjwt.springsecurityjwt.config.CommonResult;
import com.rabbit.chshady.securityandjwt.springsecurityjwt.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 廖凡
 * @Date 2019/12/26 10:54
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UmsAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @PostMapping("/login")
    @ResponseBody
    public CommonResult login(@RequestParam("username") String username,
                        @RequestParam("password")String password){
        String token = adminService.login(username,password);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
    @GetMapping("/test")
    @ResponseBody
    public CommonResult list(@RequestParam("id") String id){
        return CommonResult.success(id);
    }
}
