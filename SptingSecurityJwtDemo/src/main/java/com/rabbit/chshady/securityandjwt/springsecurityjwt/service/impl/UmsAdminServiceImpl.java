package com.rabbit.chshady.securityandjwt.springsecurityjwt.service.impl;

import com.rabbit.chshady.securityandjwt.springsecurityjwt.entity.UmsAdmin;
import com.rabbit.chshady.securityandjwt.springsecurityjwt.entity.UmsPermission;
import com.rabbit.chshady.securityandjwt.springsecurityjwt.service.UmsAdminService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 廖凡
 * @Date 2019/12/25 17:51
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return null;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long id) {
        return null;
    }
}
