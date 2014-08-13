package jp.matsushima.spring_test.dao;

import java.util.List;
import java.util.Map;

import jp.matsushima.spring_test.model.User;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ユーザーマスタ。
 * 
 * @author 2013/10/15 matsushima
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * ログイン ID、パスワードからユーザーを取得。
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public User selectForAuth(User param) {
		return (User)sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("loginid", param.getLoginid()))
				.add(Restrictions.eq("password", param.getPassword()))
				.uniqueResult();
	}

	/**
	 * ログイン ID からユーザーを取得。
	 * 
	 * @param loginid
	 * @return
	 */
	@Override
	public User selectByLoginid(String loginid) {
		return (User)sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("loginid", loginid))
				.uniqueResult();
	}

	@Override
	public List<User> selectLike(Map<String, String> param) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		Disjunction or = Restrictions.or();
		criteria.add(or);
		if (param.containsKey("loginid")) {
			or.add(Restrictions.like("loginid", param.get("loginid"), MatchMode.ANYWHERE));
		}
		if (param.containsKey("name")) {
			or.add(Restrictions.like("loginid", param.get("name"), MatchMode.ANYWHERE));
			or.add(Restrictions.like("name", param.get("name"), MatchMode.ANYWHERE));
		}
		@SuppressWarnings("unchecked")
		List<User> result = criteria.list();
		return result;
	}
}
