package com.ja.freeboard.controller;
/*
 * factory 패턴 : 인스턴스를 찍어내는 공장이라고 생각하자
 *  어떤것을 뽑아 올 때 마다 새로운 인스턴스를 생성하는게 기본 개념.
 *  이번에는 hashmap 생성한다. 
 */

import com.ja.freeboard.controller.command.*;
import java.util.*;

public class CommandFactory {
	
	private HashMap<String, CommandHandler> commandMap;
	//내부에서만 쓰면 private, 정보의 캡슐화. 
	
	public CommandFactory() {
		commandMap = new HashMap<String, CommandHandler>();
		//처음부터 끝까지 있을거니까 미리 설계를 해두는게 좋다(?)
		commandMap.put("/login_page.do", new LoginPageHandler());
		commandMap.put("/join_member_page.do", new JoinMemberPageHandler());
		commandMap.put("/join_member_process.do", new JoinMemberProcessHandler());
		commandMap.put("/login_process.do", new LoginProcessHandler());
		commandMap.put("/main_page.do", new MainPageHandler());
		commandMap.put("/logout_process.do", new LogoutProcessHandler());
		commandMap.put("/write_content_page.do", new WriteContentPageHandler());
		commandMap.put("/write_content_process.do", new WriteContentProcessHandler());
		commandMap.put("/read_content_page.do", new ReadContentPageHandler());
		commandMap.put("/delete_content_process.do", new DeleteContentProcessHandler());
		commandMap.put("/update_content_page.do", new UpdateContentPageHandler());
		commandMap.put("/update_content_process.do", new UpdateContentProcessHandler());
	}
	
	public CommandHandler getCommandHandler(String command) {
		
		return commandMap.get(command);
		
	}
	
	
}
