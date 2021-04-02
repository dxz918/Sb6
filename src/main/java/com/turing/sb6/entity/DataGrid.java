package com.turing.sb6.entity;

import lombok.Data;

import java.util.List;

//符合数据表格控件的实体类
@Data
public class DataGrid {

    private Integer total;//数据总数

    private List<?> rows;//数据集合

}
