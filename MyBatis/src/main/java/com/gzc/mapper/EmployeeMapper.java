package com.gzc.mapper;

import com.gzc.pojo.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface EmployeeMapper {

    //根据id查找单个员工(单个参数)
    Employee selectEmpById(int empId);

    //添加新员工
    int insertEmp(Employee employee);

    //根据id删除员工
    boolean deleteEmployeeById(int empId);

    //根据id更改员工信息(POJO参数)
    void updateEmployeeById(Employee employee);

    //获取所有员工列表
    List<Employee> selectAllEmp();

    //根据员工姓名和薪资获取员工信息(测试多个普通参数以及命名参数)
    //使用@Param注解来给入参命名
    Employee selectEmpByNameAndSalary(@Param("nametest") String name, @Param("salarytest") Double salary);

    //根据员工姓名和薪资获取员工信息(Map参数)
    Employee selectEmpByNameAndSalaryByMap(Map<String, Object> map);

    //查询某表的全部员工(使用$占位符实验)
    List<Employee> selectEmpByTable(@Param("tablename") String tablename);

    //查询单行数据保存到Map集合中
    Map<String,Object> selectEmpByIdPutMap(int id);

    //查询多行数据保存到Map中
    //对象id作为key
    //对象本身作为Value
    //需要用@Mapkey指定Map中的key是啥,通常指定对象的唯一标识(主键)
    @MapKey("id")//指定id作为map的key
    Map<Integer,Employee> selectAllEmpPutMap();

    //根据id查询员工以及员工所属部门(多表联合查询实验)
    List<Employee> selectEmpAndDeptById(int empid);

    //根据id查询员工以及员工所属部门(association自定义映射实验)
    Employee selectEmpAndDeptByIdAssociation(int empid);

    //根据id查询员工以及员工所属部门(association分布查询实验)
    Employee selectEmpAndDeptByIdAssociationStep(int id);

    //分布查询第二部
    List<Employee> selectEmpByDeptId(int id);

    //根据不确定的参数查询员工(动态SQL之if-where)
    List<Employee> selectEmpByObject(Employee employee);

    //根据不确定的参数查询员工(动态SQL之trim)
    List<Employee> selectEmpByObjectOfTrim(Employee employee);

    //动态SQL之修改--set
    void updateEmpByObject(Employee employee);

    //按条件查询-动态sql-choose
    List<Employee> selectEmpChoose(Employee employee);

    //通过多个id查询员工,集合中存储的是id的集合(foreach标签)
    List<Employee> selectEmpByIds(@Param("ids") List<Integer> ids);

    //批量插入员工(foreach标签的应用)
    int batchInsert(@Param("empList") List<Employee> employeeList);

}