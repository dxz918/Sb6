package com.turing.sb6.mapper;

import com.turing.sb6.entity.Emp;
import com.turing.sb6.entity.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
    int countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer empno);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    //查总数
    //@Select("select count(*) from emp")
    int selectCount(@Param("emp") Emp emp);

    //关联分页查询查询
    List<Emp> selectEmpAndDept(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,@Param("columnName") String columnName,@Param("sort") String sort,@Param("emp") Emp emp);

    //批量删除
    int deleteEmps(String [] ids);
}