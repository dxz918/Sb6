package com.turing.sb6.service.imp;

import com.turing.sb6.entity.DataGrid;
import com.turing.sb6.entity.Dept;
import com.turing.sb6.entity.Emp;
import com.turing.sb6.mapper.DeptMapper;
import com.turing.sb6.mapper.EmpMapper;
import com.turing.sb6.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpServiceImp implements EmpService {
    @Autowired
    private EmpMapper em;

    @Autowired
    private DeptMapper dm;

    @Override
    public DataGrid showData(Integer pageNum, Integer pageSize,String columnName,String sort,Emp emp) {
        DataGrid dataGrid = new DataGrid();
        dataGrid.setTotal(em.selectCount(emp));
        dataGrid.setRows(em.selectEmpAndDept((pageNum - 1) * pageSize, pageSize,columnName,sort,emp));
        return dataGrid;
    }

    @Override
    public int addEmp(Emp emp) {
        return em.insertSelective(emp);
    }

    @Override
    public int updEmp(Emp emp) {
        return em.updateByPrimaryKeySelective(emp);
    }

    @Override
    public int delEmps(String [] ids) {
        return em.deleteEmps(ids);
    }

    @Override
    public List<Dept> selDepts() {
        return dm.selectByExample(null);
    }
}
