package com.gzc.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author: 拿破仑
 * @Date&Time: 2023/04/12  09:41  周三
 * @Project: SSMTest
 * @Write software: IntelliJ IDEA
 * @Purpose: 在此处编辑
 */
public class Dept implements Serializable {

    private String deptName;
    private Integer deptId;

    //加上其他实体类的列表则表示和另一个实体类建立了一对多关系,部门1-->n员工
    private List<Employee> employeeList;

    public Dept(String deptName, Integer deptId, List<Employee> employeeList) {
        this.deptName = deptName;
        this.deptId = deptId;
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptName='" + deptName + '\'' +
                ", deptId=" + deptId +
                ", employeeList=" + employeeList +
                '}';
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Dept() {
    }
}