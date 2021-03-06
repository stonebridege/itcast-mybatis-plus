import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.stonebridge.mp.simple.mapper.UserMapper;
import com.stonebridge.mp.simple.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatisPlus {
    @Test
    public void testUserList() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //通过Mybatis Plus提供MybatisSqlSessionFactoryBuilder构建，
        //通过MybatisSqlSessionFactoryBuilder构建后就实现MybatisPlus和Mybatis的整合
        //import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
        MybatisSqlSessionFactoryBuilder builder = new MybatisSqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 可以调用BaseMapper中定义的方法
        List<User> list = userMapper.selectList(null);
        for (User user : list) {
            System.out.println(user);
        }
    }
}
