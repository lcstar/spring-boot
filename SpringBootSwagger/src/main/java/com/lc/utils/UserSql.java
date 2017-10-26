package com.lc.utils;

import com.lc.model.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSql {
    public String select(User user){
        return new SQL(){
            String name = user.getName();
            String password = user.getPassword();
            String id = user.getId().toString();
            {
                SELECT("id,name,password");
                FROM("user");
                WHERE("id = #{id} AND name = #{name} AND password = #{password}");
            }

        }.toString();
    }

}
