package com.fj.webauto.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fj.webauto.browser.Browser;

/**
 * author:张福军 date:2018年7月2日 time:下午5:42:51
 * 
 **/

public class BatisFactory {

	static SqlSession session = null;

	public static synchronized SqlSession genDb(String resource) {
		if (null == session) {
			// synchronized (session) {
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
		}
		// }
		return session;

	}

	public static void closeDb() {
		if (null != session) {
			session.close();
		}
	}

}
