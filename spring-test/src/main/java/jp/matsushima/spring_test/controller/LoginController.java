package jp.matsushima.spring_test.controller;

import jp.matsushima.spring_test.model.User;
import jp.matsushima.spring_test.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * ログインページ。
 * 
 * @author 2013/10/16 matsushima
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	/** ユーザーサービス。 */
	@Autowired
	private UserService userService;

	/**
	 * ログインページ。
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	/**
	 * ログイン。
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, params = {"login"})
	public ModelAndView login(User param) {
		// 認証。
		User result = userService.auth(param);
		if (null != result) {
			// ログイン -> 認証成功: インデックスページ
			return new ModelAndView("index", "user", result);
		} else {
			// ログイン -> 認証失敗: ログインページ
			return new ModelAndView("login", "message", "ログインIDまたはパスワードが違います。");
		}
	}
}
