package net.wanho.util;

import net.wanho.test.Test01;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtil {
    private static ThreadLocal<SqlSession> threadLocal;
    private static  SqlSessionFactory sf;

    static {
        threadLocal = new ThreadLocal<SqlSession>();
        InputStream inputStream = Test01.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
         sf = new SqlSessionFactoryBuilder().build(inputStream);
    }
    public static SqlSession getSession() {
        SqlSession session = threadLocal.get();
        if (session == null) {
            session = sf.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSession() {
        SqlSession session = threadLocal.get();
        if (session != null) {
            session.close();
            threadLocal.remove();
        }
    }
}
