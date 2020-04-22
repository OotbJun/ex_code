package com.ja.freeboard.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {
	
	//모든 커맨드 핸들러들은 여기서 정의하는 구조를 오버라이딩해야한다. 
	public String process(HttpServletRequest request, HttpServletResponse response);
	
	
}
