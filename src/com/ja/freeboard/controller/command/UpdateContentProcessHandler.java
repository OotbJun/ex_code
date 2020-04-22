package com.ja.freeboard.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.freeboard.model.*;
import com.ja.freeboard.vo.*;

public class UpdateContentProcessHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		
		new Boarddao().update(b_no, b_title, b_content);
		
		return "redirect:./read_content_page.do?b_no="+b_no;
	}

}
