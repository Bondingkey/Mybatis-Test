package com.gzc.mapper;

import com.gzc.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    //根据id查找单个员工
    Employee selectEmpById(int empId);

    void insertEmp(Employee employee);

    void deleteEmployeeById(int empId);

    void updateEmployeeById(Employee employee);

    List<Employee> selectAllEmp();

}