package com.rabbit.chshady.securityandjwt.springsecurityjwt.service.impl;

import com.rabbit.chshady.securityandjwt.springsecurityjwt.entity.AdminUserDetails;
import com.rabbit.chshady.securityandjwt.springsecurityjwt.entity.UmsAdmin;
import com.rabbit.chshady.securityandjwt.springsecurityjwt.entity.UmsPermission;
import com.rabbit.chshady.securityandjwt.springsecurityjwt.service.UmsAdminService;
import com.rabbit.chshady.securityandjwt.springsecurityjwt.util.JwtCreateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 廖凡
 * @Date 2019/12/25 17:51
 */
@Slf4j
@Service

public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private JwtCreateUtil jwtCreateUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdmin umsAdmin = new UmsAdmin();
        if(username.equals("admin")){
            umsAdmin.setUsername(username);
            umsAdmin.setPassword("admin");
        }
        return umsAdmin;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long id) {
        List<UmsPermission> permissionList = new ArrayList<>();
        UmsPermission permission = new UmsPermission();
        permission.setValue("pms:product:read");
        permissionList.add(permission);
        return permissionList;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            List<UmsPermission> permissionList = new ArrayList<>();
            UmsPermission permission = new UmsPermission();
            permission.setValue("pms:product:read");
            permissionList.add(permission);
            UmsAdmin umsAdmin =  new UmsAdmin();
            umsAdmin.setUsername("admin");
            umsAdmin.setPassword("admin");
            UserDetails userDetails = new AdminUserDetails(umsAdmin,permissionList);
            if(!passwordEncoder.matches(password,passwordEncoder.encode("admin"))){
                throw new BadCredentialsException("密码不正确");
            }

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtCreateUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }
}
