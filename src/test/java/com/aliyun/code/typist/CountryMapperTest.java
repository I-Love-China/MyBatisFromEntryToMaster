package com.aliyun.code.typist;

import com.aliyun.code.typist.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CountryMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 因为目前只有一个 namespace，所以直接用 selectAll 即可
            // 如果需要指定命名空间的话: namespace + "." + methodName
            List<Country> countries = sqlSession.selectList("selectAll");
            printCountries(countries);
        }
    }

    private void printCountries(List<Country> countries) {
        if (null == countries || countries.isEmpty()) {
            return;
        }

        for (Country country : countries) {
            System.out.println(country);
        }
    }
}
