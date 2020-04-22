package com.ja.freeboard.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.freeboard.model.*;
import com.ja.freeboard.vo.*;
import java.util.*;

public class MainPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
	
		ArrayList<ContentDataVo> contentList = new ArrayList<ContentDataVo>();

		ArrayList<BoardVo> boardList = new Boarddao().selectAll();

		Memberdao memberDao = new Memberdao();

		for (BoardVo boardVo : boardList) {
			// 조인을 하지 않고, 코드로 조인과 같은 결과를 뽑아낸다.
			MemberVo memberVo = memberDao.selectByNo(boardVo.getM_no());

			ContentDataVo contentDataVo = new ContentDataVo(memberVo, boardVo);

			contentList.add(contentDataVo);
		}
		
		request.setAttribute("contentList", contentList); 
		//리퀘스트 객체에 담으면 - 포워딩을 할 때 까지는 데이터가 유지된다. "" 안에 넣어주는걸로 jsp에서 작성해준다.

		return "/WEB-INF/view/main_page.jsp";
	}

}
