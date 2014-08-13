package jp.matsushima.spring_test.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//2013/11/01
@Repository
public class SetUpDaoImpl implements SetUpDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void setup() {
		System.out.println("startup"+sessionFactory);
		sessionFactory.getCurrentSession().createSQLQuery("drop table user_mst if exists").executeUpdate();
		sessionFactory.getCurrentSession().createSQLQuery("create text table user_mst (id integer, loginid varchar(100), password varchar(100), name varchar(100))").executeUpdate();
		sessionFactory.getCurrentSession().createSQLQuery("set table user_mst source 'user_mst.csv'").executeUpdate();
		sessionFactory.getCurrentSession().createSQLQuery("insert into user_mst values(2,'ddd','ccc','eee')").executeUpdate();
	}

//
//	public StartUpDaoImpl() {
//		setup();
//	}
}
