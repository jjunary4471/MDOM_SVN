package mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapClient {

	public static SqlSession getSqlSession() {
		String resource = "myBatisConfig.xml";
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlMapper.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return session;
	}

	public static void closeSession(SqlSession session) {
		session.close();

	}
}
