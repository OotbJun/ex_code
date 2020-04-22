package com.ja.freeboard.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.freeboard.model.Boarddao;

public class DeleteContentProcessHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		
		new Boarddao().delete(b_no);
		
		return "redirect:./main_page.do";
	}

}
