package com.fhr.ranblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author fhr
 * @date 2017/06/07 
 * @version 1.0
 */
@Controller
@RequestMapping("/code")
public class CodeController {
	
	@RequestMapping("/kitchen-sink")
	public String kitchen_sink(){
		return "code/kitchen-sink/kitchen-sink";
	}
	
	@RequestMapping("/bookmarklet")
	public String bookmarklet(){
		return "code/bookmarklet/index";
	}
	@RequestMapping("/editor")
	public String editor(){
		return "code/editor";
	}
	
}
