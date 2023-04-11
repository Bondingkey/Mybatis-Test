import com.gzc.mapper.EmployeeMapper;
import com.gzc.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: 拿破仑
 * @Date&Time: 2023/04/10  20:40  周一
 * @Project: SSMTest
 * @Write software: IntelliJ IDEA
 * @Purpose: 在此处编辑
 */
public class TestMybatis {

    @Test
    public void test1(){

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
    public void test2(){
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
            Employee insertemployee = new Employee(6,"kkk",40.0,"kk.com");
            employeeMapper.insertEmp(insertemployee);

            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test3(){
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
            employeeMapper.deleteEmployeeById(5);

            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test4(){
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
            Employee employee = new Employee(3,"lisi666",52.0,"lisi666@com");
            employeeMapper.updateEmployeeById(employee);

            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Test
    public void test5(){
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

            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}