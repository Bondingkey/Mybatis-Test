import com.gzc.mapper.EmployeeMapper;
import com.gzc.pojo.Employee;
import com.gzc.pojo.EmployeeExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 拿破仑
 * @Date&Time: 2023/04/13  17:06  周四
 * @Project: SSMTest
 * @Write software: IntelliJ IDEA
 * @Purpose: 在此处编辑
 */
public class TestMbg {

    /*
    * 测试代码生成器
    * */
    @Test
    public void test1() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("src/main/resources/mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback,warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void test2(){//测试生成的代码
//        try {
//            //mybatis配置文件所在位置
//            String resources= "mybatis-config.xml";
//            //加载mybatis配置文件
//            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
//            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//            //使用sqlSessionFactory工厂创建一个openSession对象
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            //使用openSession对象获得EmployeeMapper.class的代理对象
//            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            List<Employee> employees = mapper.selectAll();
//            employees.forEach(System.out::println);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Test
    public void test3(){//测试带条件的CRUD
        try {
            //mybatis配置文件所在位置
            String resources= "mybatis-config.xml";
            //加载mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            //使用sqlSession工厂模式根据mybatis配置文件创建一个sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //使用sqlSessionFactory工厂创建一个openSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            //创建一个带有条件查询的员工对象
            EmployeeExample example = new EmployeeExample();
            //创建条件对象
            EmployeeExample.Criteria criteria = example.createCriteria();
            //使用条件
            //criteria.andIdBetween(1,7);
            criteria.andLastNameLike("k%");

            //使用带有条件查询的方法
            List<Employee> employees = mapper.selectByExample(example);
            employees.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
