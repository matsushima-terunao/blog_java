package jp.matsushima.spring_test.dao;

import java.util.List;
import java.util.Map;

import jp.matsushima.spring_test.model.User;

/**
 * ユーザーマスタ。
 * 
 * @author 2013/10/15 matsushima
 *
 */
public interface UserDao {

	/**
	 * ログイン ID、パスワードからユーザーを取得。
	 * 
	 * @param param
	 * @return
	 */
	public User selectForAuth(User param);

	/**
	 * ログイン ID からユーザーを取得。
	 * 
	 * @param loginid
	 * @return
	 */
	public User selectByLoginid(String loginid);

	public List<User> selectLike(Map<String, String> param);
}
