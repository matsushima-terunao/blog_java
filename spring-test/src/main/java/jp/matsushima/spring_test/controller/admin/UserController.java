package jp.matsushima.spring_test.controller.admin;

import java.util.List;
import java.util.Map;

import jp.matsushima.spring_test.model.User;
import jp.matsushima.spring_test.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//2013/10/28
@Controller
@RequestMapping("/admin/user")
public class UserController {

	/** ユーザーサービス。 */
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam Map<String, String> param) {
		List<User> models = userService.search(param);
		return new ModelAndView("admin/user/list", "models", models);
	}

	@RequestMapping(value = "/{loginid}/", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("loginid") String loginid) {
		User model = userService.getByLoginid(loginid);
		return new ModelAndView("admin/user/detail", "model", model);
	}

	@RequestMapping(value = "/{loginid}/modify", method = RequestMethod.GET)
	public ModelAndView modify(@PathVariable("loginid") String loginid) {
		User model = userService.getByLoginid(loginid);
		return new ModelAndView("admin/user/edit", "model", model).addObject("action", "modify");
	}

	@RequestMapping(value = "/{loginid}/modify", method = RequestMethod.POST)
	public String confirmModify(@RequestParam Map<String, String> param) {
		return "admin/user/detail";
	}
}
