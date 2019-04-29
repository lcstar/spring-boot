package com.lc.mapper;

import com.lc.model.Permission;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(long userId);
}