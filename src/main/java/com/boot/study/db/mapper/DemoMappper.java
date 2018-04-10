package com.boot.study.db.mapper;

import com.boot.study.db.Demo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoMappper {


    @Insert("insert into Demo(name,password) values(#{name},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public long save(Demo name);


    @Select("select * from Demo where name = #{name}")
    public List<Demo> likeName(String name);

    @Select("select * from Demo where id = #{id}")
    public Demo getById(long id);

    @Select("select name from Demo where id = #{id}")
    public String getNameById(long id);


    @Select("select * from Demo")
    public List<Demo> findAll();
}