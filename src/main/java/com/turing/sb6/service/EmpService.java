package com.turing.sb6.service;

import com.turing.sb6.entity.DataGrid;
import com.turing.sb6.entity.Dept;
import com.turing.sb6.entity.Emp;

import java.util.List;

public interface EmpService {
    //分页
    public DataGrid showData(Integer pageNum, Integer pageSize, String columnName, String sort,Emp emp);

    //添加
    public int addEmp(Emp emp);

    //修改
    public int updEmp(Emp emp);

    //批量删除
    public int delEmps(String[] ids);

    //查部门信息
    public List<Dept> selDepts();

}
