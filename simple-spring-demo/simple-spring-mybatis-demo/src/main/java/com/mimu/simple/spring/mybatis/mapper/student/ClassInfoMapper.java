package com.mimu.simple.spring.mybatis.mapper.student;

import com.mimu.simple.spring.mybatis.model.student.ClassInfo;
import com.mimu.simple.spring.mybatis.model.student.ClassInfoExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClassInfoMapper {
    long countByExample(ClassInfoExample example);

    int deleteByExample(ClassInfoExample example);

    @Delete({
        "delete from class_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into class_info (academy, grade)",
        "values (#{academy,jdbcType=VARCHAR}, #{grade,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    List<ClassInfo> selectByExample(ClassInfoExample example);

    @Select({
        "select",
        "id, academy, grade",
        "from class_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mimu.simple.spring.mybatis.generator.mapper.student.ClassInfoMapper.BaseResultMap")
    ClassInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassInfo record, @Param("example") ClassInfoExample example);

    int updateByExample(@Param("record") ClassInfo record, @Param("example") ClassInfoExample example);

    int updateByPrimaryKeySelective(ClassInfo record);

    @Update({
        "update class_info",
        "set academy = #{academy,jdbcType=VARCHAR},",
          "grade = #{grade,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ClassInfo record);
}