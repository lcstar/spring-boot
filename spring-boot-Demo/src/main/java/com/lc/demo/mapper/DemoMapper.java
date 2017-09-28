package com.lc.demo.mapper;

import com.lc.demo.model.Demo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoMapper {

    @Select("select * from Demo")
    public List<Demo> getDemos();
}
