package com.lc.config;

import com.lc.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by lc
 * createTime 2019/4/29.
 */
@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource{
    @Autowired
    private PermissionMapper permissionMapper;

    private HashMap<String,Collection<ConfigAttribute>> map = null;

    public void loadResourceDefine(){

    }
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
