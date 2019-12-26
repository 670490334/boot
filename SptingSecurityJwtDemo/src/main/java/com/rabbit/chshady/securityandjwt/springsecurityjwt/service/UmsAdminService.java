package com.rabbit.chshady.securityandjwt.springsecurityjwt.service;

import com.rabbit.chshady.securityandjwt.springsecurityjwt.entity.UmsAdmin;
import com.rabbit.chshady.securityandjwt.springsecurityjwt.entity.UmsPermission;

import java.util.List;

/**
 * @Author 廖凡
 * @Date 2019/12/25 17:50
 */
public interface UmsAdminService {
    UmsAdmin getAdminByUsername(String username);

    List<UmsPermission> getPermissionList(Long id);

    String login(String username,String password);
}
