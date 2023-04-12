import com.gzc.mapper.DeptMapper;
import com.gzc.mapper.EmployeeMapper;
import com.gzc.pojo.Dept;
import com.gzc.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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
    
    @Test
    public void test10(){
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = employeeMapper.selectEmpAndDeptById(1);
            employees.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test11(){
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = employeeMapper.selectEmpAndDeptByIdAssociation(1);
            System.out.println("employee = " + employee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test12(){
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = employeeMapper.selectEmpAndDeptByIdAssociationStep(2);
            System.out.println("employee = " + employee.getDept());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test13(){
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
            Dept dept = mapper.selectDeptAndEmpListByDeptId(1);
            System.out.println("dept = " + dept);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test14(){//通过部门id查询部门信息以及员工信息(coll的分布实验)
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
            Dept dept = mapper.selectDeptAndEmpListByDeptIdStep(1);
            System.out.println("dept = " + dept);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test15(){//动态SQL -if-where
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = new Employee();
            employee.setId(1);
            employee.setName("张三");
            //employee.setEmail("za@163.com");
            List<Employee> employees = mapper.selectEmpByObject(employee);
            employees.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test16(){//动态SQL -trim
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = new Employee();
            employee.setId(1);
            employee.setName("张三");
            employee.setEmail("za@163.com");
            //employee.setSalary(500.00);

            List<Employee> employees = mapper.selectEmpByObjectOfTrim(employee);
            employees.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test17(){
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = new Employee();
            employee.setId(1);
            employee.setName("张三");
            employee.setEmail("za@164.com");
            //employee.setSalary(500.00);

            mapper.updateEmpByObject(employee);

            sqlSession.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test18(){//动态SQL-when(选择语句)
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = new Employee();
            //employee.setId(1);
            //employee.setName("kkk");
            employee.setEmail("za@164.com");
            employee.setSalary(500.00);

            List<Employee> employees = mapper.selectEmpChoose(employee);
            employees.forEach(System.out::println);
            sqlSession.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test19(){//动态foreach(循环语句)
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            List<Integer> objects = new ArrayList<>();
            objects.add(1);
            objects.add(7);
            objects.add(10);

            List<Employee> employees = mapper.selectEmpByIds(objects);

            employees.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test20(){//foreach练习:批量插入
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            List<Employee> objects = new ArrayList<>();
            objects.add(new Employee(null,"王五",50.5,"wangwu@.com"));
            objects.add(new Employee(null,"王5五",50.5,"wangwu@.com"));
            objects.add(new Employee(null,"王55五",50.5,"wangwu@.com"));
            objects.add(new Employee(null,"王555五",50.5,"wangwu@.com"));

            int i = mapper.batchInsert(objects);
            System.out.println("i = " + i);

            sqlSession.commit();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test21(){//一级缓存实验
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = mapper.selectEmpById(1);
            System.out.println("employee = " + employee);
            System.out.println("=========================================");
            Employee employee1 = mapper.selectEmpById(1);
            System.out.println("employee1 = " + employee1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test22(){//一级缓存失效的五种情况之一-不同的sqlSession
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            EmployeeMapper mapper1 = sqlSession1.getMapper(EmployeeMapper.class);

            Employee employee = mapper.selectEmpById(1);
            System.out.println("employee = " + employee);
            sqlSession.close();//资源释放
            //sqlSession.clearCache();  //sqlSession.clearCache不会清除二级缓存
            System.out.println("=========================================");
            Employee employee1 = mapper1.selectEmpById(1);
            System.out.println("employee1 = " + employee1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test23(){//一级缓存失效的五种情况之一:主动清空缓存或提交事务
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //使用openSession对象获得EmployeeMapper.class的代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = mapper.selectEmpById(1);
            System.out.println("employee = " + employee);

            //主动清空缓存或提交事务
            //sqlSession.clearCache();
            //sqlSession.commit();
            System.out.println("=========================================");
            Employee employee1 = mapper.selectEmpById(1);
            System.out.println("employee1 = " + employee1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}