package com.aliyun.code.typist;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

import java.io.IOException;
import java.io.Reader;

public class BaseMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try (Reader config = Resources.getResourceAsReader("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
