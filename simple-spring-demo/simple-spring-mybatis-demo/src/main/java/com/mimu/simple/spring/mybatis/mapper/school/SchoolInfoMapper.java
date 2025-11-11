package com.mimu.simple.spring.mybatis.mapper.school;

import com.mimu.simple.spring.mybatis.model.school.SchoolInfo;
import com.mimu.simple.spring.mybatis.model.school.SchoolInfoExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SchoolInfoMapper {
    long countByExample(SchoolInfoExample example);

    int deleteByExample(SchoolInfoExample example);

    @Delete({
        "delete from school_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into school_info (serial, name, ",
        "address)",
        "values (#{serial,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SchoolInfo record);

    int insertSelective(SchoolInfo record);

    List<SchoolInfo> selectByExample(SchoolInfoExample example);

    @Select({
        "select",
        "id, serial, name, address",
        "from school_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mimu.simple.spring.mybatis.generator.mapper.school.SchoolInfoMapper.BaseResultMap")
    SchoolInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SchoolInfo record, @Param("example") SchoolInfoExample example);

    int updateByExample(@Param("record") SchoolInfo record, @Param("example") SchoolInfoExample example);

    int updateByPrimaryKeySelective(SchoolInfo record);

    @Update({
        "update school_info",
        "set serial = #{serial,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SchoolInfo record);
}