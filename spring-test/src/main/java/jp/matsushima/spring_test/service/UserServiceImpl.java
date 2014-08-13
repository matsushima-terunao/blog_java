package jp.matsushima.spring_test.service;

import java.util.List;
import java.util.Map;

import jp.matsushima.spring_test.dao.SetUpDao;
import jp.matsushima.spring_test.dao.UserDao;
import jp.matsushima.spring_test.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ユーザーサービス。
 * 
 * @author 2013/10/15 matsushima
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * 認証。
	 * 
	 * @param param
	 * @return
	 */
	@Override
	@Transactional
	public User auth(User param) {
		if ((null == param.getLoginid()) || (param.getLoginid().isEmpty())
				|| (null == param.getPassword()) || (param.getPassword().isEmpty())) {
			return null;
		}
		return userDao.selectForAuth(param);
	}

	@Override
	@Transactional
	public List<User> search(Map<String, String> param) {
		return userDao.selectLike(param);
	}

	@Override
	@Transactional
	public User getByLoginid(String loginid) {
		return userDao.selectByLoginid(loginid);
	}
}
