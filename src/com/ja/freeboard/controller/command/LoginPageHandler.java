package com.ja.freeboard.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageHandler implements CommandHandler {
	
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
//		return "redirect:/main_page.jsp";
		return "/WEB-INF/view/login_page.jsp"; //String 타입으로 리턴함.
//		리턴되는 문자열에 redirect가 있는지 없는지에 따라 포워딩할지 리다이렉트할지 결정된다
	}
}
