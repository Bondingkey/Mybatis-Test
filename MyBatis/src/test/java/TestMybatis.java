import com.gzc.mapper.EmployeeMapper;
import com.gzc.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author: 拿破仑
 * @Date&Time: 2023/04/10  20:40  周一
 * @Project: SSMTest
 * @Write software: IntelliJ IDEA
 * @Purpose: 在此处编辑
 */
public class TestMybatis {

    @Test
    public void test1(){//根据id查找

        try {
            //mybatis配置文件目录所在位置
            String resource = "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //利用工厂模式根据mybatis配置文件创建一个SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //根据SqlSessionFactory对象获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //获取EmployeeMapper的代理对象，参数写你代理的类的class
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            //System.out.println(employeeMapper.getClass().getName());//带有$开头的类名为代理类
            //调用方法
            Employee employee = employeeMapper.selectEmpById(1);
            System.out.println(employee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2(){//添加单个员工
        try {
            //mybatis配置文件目录所在位置
            String resource = "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //利用工厂模式根据mybatis配置文件创建一个SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //根据SqlSessionFactory对象获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //获取EmployeeMapper的代理对象，参数写你代理的类的class
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            //System.out.println(employeeMapper.getClass().getName());//带有$开头的类名为代理类

            //创建对象调用方法
            Employee insertemployee = new Employee(null,"kkk",40.0,"kk.com");
            int i = employeeMapper.insertEmp(insertemployee);
            //影响行数
            System.out.println("影响行数为"+i);
            //获取自增主键值
            System.out.println("自增主键Id:"+insertemployee.getId());

            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test3(){//删除单个员工
        try {
            //mybatis配置文件目录所在位置
            String resource = "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //利用工厂模式根据mybatis配置文件创建一个SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //根据SqlSessionFactory对象获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //获取EmployeeMapper的代理对象，参数写你代理的类的class
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            //System.out.println(employeeMapper.getClass().getName());//带有$开头的类名为代理类
            boolean b = employeeMapper.deleteEmployeeById(15);
            //是否影响
            System.out.println("是否影响"+b);

            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test4(){//更新员工信息
        try {
            //mybatis配置文件目录所在位置
            String resource = "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //利用工厂模式根据mybatis配置文件创建一个SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //根据SqlSessionFactory对象获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //获取EmployeeMapper的代理对象，参数写你代理的类的class
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            //System.out.println(employeeMapper.getClass().getName());//带有$开头的类名为代理类
            Employee employee = new Employee(2,"lisi666",52.0,"lisi666@com");
            employeeMapper.updateEmployeeById(employee);

            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Test
    public void test5(){//获取所有员工列表
        try {
            //mybatis配置文件目录所在位置
            String resource = "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //利用工厂模式根据mybatis配置文件创建一个SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //根据SqlSessionFactory对象获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //获取EmployeeMapper的代理对象，参数写你代理的类的class
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            //System.out.println(employeeMapper.getClass().getName());//带有$开头的类名为代理类
            List<Employee> employees = employeeMapper.selectAllEmp();
            employees.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test6(){//根据姓名和薪资获取员工(命名参数和多参数实验)
        try {
            //mybatis配置文件目录所在位置
            String resource = "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //利用工厂模式根据mybatis配置文件创建一个SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //根据SqlSessionFactory对象获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //获取EmployeeMapper的代理对象，参数写你代理的类的class
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            //System.out.println(employeeMapper.getClass().getName());//带有$开头的类名为代理类

            Employee employee = employeeMapper.selectEmpByNameAndSalary("张三", Double.valueOf(500));
            System.out.println(employee);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test7(){//根据姓名和薪资获取员工(Map实验)
        try {
            //mybatis配置文件目录所在位置
            String resource = "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //利用工厂模式根据mybatis配置文件创建一个SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //根据SqlSessionFactory对象获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //获取EmployeeMapper的代理对象，参数写你代理的类的class
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            //System.out.println(employeeMapper.getClass().getName());//带有$开头的类名为代理类
            Map<String,Object> map = new HashMap<>();
            map.put("nameeee","张三");
            map.put("sa",500);
            Employee employee = employeeMapper.selectEmpByNameAndSalaryByMap(map);
            System.out.println(employee);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test8(){//$占位符的使用,用来替换不支持?的情况,如from XX
        try {
            //mybatis配置文件目录所在位置
            String resource = "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //利用工厂模式根据mybatis配置文件创建一个SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //根据SqlSessionFactory对象获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //获取EmployeeMapper的代理对象，参数写你代理的类的class
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            //System.out.println(employeeMapper.getClass().getName());//带有$开头的类名为代理类
            List<Employee> tbl_employee = employeeMapper.selectEmpByTable("tbl_employee");
            tbl_employee.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test9(){//测试查询单行数据以map形式返回
        try {
            //mybatis配置文件目录所在位置
            String resource = "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //利用工厂模式根据mybatis配置文件创建一个SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //根据SqlSessionFactory对象获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //获取EmployeeMapper的代理对象，参数写你代理的类的class
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
//            //测试查询单行数据保存到Map中
//            Map<String, Object> stringObjectMap = employeeMapper.selectEmpByIdPutMap(1);
//            System.out.println("stringObjectMap = " + stringObjectMap);

            Map<Integer, Employee> integerEmployeeMap = employeeMapper.selectAllEmpPutMap();
            System.out.println("integerEmployeeMap = " + integerEmployeeMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}