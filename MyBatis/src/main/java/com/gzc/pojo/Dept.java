package com.gzc.pojo;

/**
 * @author: 拿破仑
 * @Date&Time: 2023/04/12  09:41  周三
 * @Project: SSMTest
 * @Write software: IntelliJ IDEA
 * @Purpose: 在此处编辑
 */
public class Dept {

    private String deptName;
    private Integer deptId;

    @Override
    public String toString() {
        return "Dept{" +
                "deptName='" + deptName + '\'' +
                ", deptId=" + deptId +
                '}';
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

    public Dept(String deptName, Integer deptId) {
        this.deptName = deptName;
        this.deptId = deptId;
    }

    public Dept() {
    }
}
