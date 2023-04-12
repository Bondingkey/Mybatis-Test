package com.gzc.mapper;

import com.gzc.pojo.Dept;

/**
 * @author: 拿破仑
 * @Date&Time: 2023/04/12  11:54  周三
 * @Project: SSMTest
 * @Write software: IntelliJ IDEA
 * @Purpose: 在此处编辑
 */
public interface DeptMapper{

    Dept selectDeptById(int id);

    //通过部门id获取部门信息及其所属员工信息
    Dept selectDeptAndEmpListByDeptId(int id);

    //通过部门id获取部门信息以及所属员工信息(Coll分步查询)
    Dept selectDeptAndEmpListByDeptIdStep(int id);

}
