import com.example.test1.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: MybatisTest
 * @author: benjamin
 * @version: 1.0
 * @description: TODO
 * @createTime: 2019/07/13/11:50
 */

public class MybatisTest {
    public static void main(String[] args) {

    }

    //通过Id查询一个用户
    @Test
    public void testSearchById() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //4.执行Sql语句
        User user = session.selectOne("User.findUserById", 1);
        //5. 打印结果
        System.out.println(user);
        //6.释放资源
        session.close();
        in.close();
    }

    //根据用户名模糊查询用户列表
    @Test
    public void testFindUserByUsername() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //4.执行Sql语句
        List<User> list = session.selectList("User.findUserByUsername", "测试");
        //5. 打印结果
        for (User user:list) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }

    //添加用户
    @Test
    public void testInsertUser() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.执行Sql语句
        User user = new User();
        user.setUsername("小强");
        user.setBirthday(new Date());
        user.setAddress("广州");
        user.setSex("男");
        int i = sqlSession.insert("User.insertUser", user);
        sqlSession.commit();
        //5. 打印结果
        // 刚保存用户，此时用户ID需要返回。执行完上面insert程序后，此时就能知道用户的ID是多少
        // 需要在User.xml文件中配置
        System.out.println("插入id:"+user.getId());//插入id:30

        //6.释放资源
        sqlSession.close();
        in.close();
    }

    //更新用户
    @Test
    public void testUpdateUserById() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.执行Sql语句
        User user = new User();
        user.setId(3);
        user.setUsername("小李");
        user.setBirthday(new Date());
        user.setAddress("深圳");
        user.setSex("女");
        int i = sqlSession.insert("User.updateUserById", user);
        sqlSession.commit();
        //5. 打印结果
        System.out.println(user.getId());
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    //删除用户
    @Test
    public void testDeleteUserById() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.执行Sql语句
        int i = sqlSession.insert("User.deleteUserById", 3);
        sqlSession.commit();
        //5. 打印结果
        System.out.println(i);
        //6.释放资源
        sqlSession.close();
        in.close();
    }
}