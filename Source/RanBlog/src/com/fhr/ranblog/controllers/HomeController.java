package com.fhr.ranblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 主页控制器
 * @author fhr
 * @date 2017/06/07
 * @version 1.0
 */
@Controller
public class HomeController {
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
