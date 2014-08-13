package jp.matsushima.spring_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * インデックスページ。
 * 
 * @author 2013/10/19 matsushima
 */
@Controller
@RequestMapping({"/index", "/"})
public class IndexController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
}
