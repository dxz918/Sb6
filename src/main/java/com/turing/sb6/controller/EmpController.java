package com.turing.sb6.controller;

import com.turing.sb6.entity.DataGrid;
import com.turing.sb6.entity.Dept;
import com.turing.sb6.entity.Emp;
import com.turing.sb6.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService es;

    @ResponseBody
    @GetMapping("/page")
    //@RequestParam:将请求参数绑定给形参
    public DataGrid show(@RequestParam(value = "page") Integer pageNum, @RequestParam(value = "rows") Integer pageSize, @RequestParam(value = "sort", defaultValue = "") String columnName, @RequestParam(value = "order", defaultValue = "") String sort,Emp emp) {
        return es.showData(pageNum, pageSize, columnName, sort, emp);
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(Emp emp) {
        return es.addEmp(emp) > 0 ? "success" : "error";
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(Emp emp) {
        return es.updEmp(emp) > 0 ? "success" : "error";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(String[] ids) {
        return es.delEmps(ids) > 0 ? "success" : "error";
    }

    //部门信息
    @ResponseBody
    @PostMapping("/depts")
    public List<Dept> depts() {
        return es.selDepts();
    }
}
