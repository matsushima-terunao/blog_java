package jp.matsushima.spring_test.service;

import java.util.List;
import java.util.Map;

import jp.matsushima.spring_test.model.User;

/**
 * ユーザーサービス。
 * 
 * @author 2013/10/15 matsushima
 */
public interface UserService {

	/**
	 * 認証。
	 * 
	 * @param param
	 * @return
	 */
	public User auth(User param);

	public List<User> search(Map<String, String> param);

	public User getByLoginid(String loginid);
}
