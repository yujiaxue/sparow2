package com.fj.webauto.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import com.fj.webauto.db.po.MyCase;
import com.fj.webauto.db.po.Steps;

public class MyBatis {
	public Object selectOne(String namespaceid, Object where) {
		// MyCase mc = session.selectOne("test.selectCase", 1);
		// System.out.println(mc);
		return null;
	}

	// @Test
	public void init() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		MyCase mc = session.selectOne("test.selectCase", 1);
		System.out.println(mc);

	}

	@Test
	public void init1() {
		String resource = "mybatis-config-sqlite.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		 MyCase cc = new MyCase();
		 cc.setCasename("订单2");
		 cc.setOwner("福军1wwwwww");
		 session.insert("test.insertCase", cc);
		 session.commit();
		 System.out.println("id is "+ cc.getId());
		
//		Steps s = new Steps();
//		s.setCaseId(3);
//		s.setStepName("如梦初醒");
//		s.setImg("/adf/asf/sd/f/ee/ee.png");
//		session.insert("test.insertStep", s);
		
		
//		session.insert("test.initDB");
//		session.commit();
//		session.insert("test.initdb2");
//		session.commit();

		//System.out.println(s.getId());
		// List<MyCase> mc = session.selectList("test.selectCaseByName", "福");
		//
		// System.out.println(mc);
		session.close();

	}

}
