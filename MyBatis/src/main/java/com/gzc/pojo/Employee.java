package com.gzc.pojo;

import java.io.Serializable;

/**
 * @author: 拿破仑
 * @Date&Time: 2023/04/10  20:10  周一
 * @Project: SSMTest
 * @Write software: IntelliJ IDEA
 * @Purpose: 在此处编辑
 */
public class Employee implements Serializable {//设置二级缓存需要实现的接口

    private Integer id;
    private String name;
    private Double salary;
    private String email;

    //使员工和部门两个实体建立一对一关系的属性
    private Dept dept;

    public Employee(Integer id, String name, Double salary, String email, Dept dept) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.email = email;
        this.dept = dept;
    }




    public Employee(Integer id, String name, Double salary, String email) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                '}';
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee() {
    }
}