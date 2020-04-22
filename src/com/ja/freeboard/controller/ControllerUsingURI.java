package com.ja.freeboard.controller;

// 이 클래스는 web.xml에 의해서 톰캣이 처음 한번 생성되는 클래스이다.
// 따라서 그 안의 생성자도 딱 1번 생성된다.

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.freeboard.controller.command.CommandHandler;

/**
 * Servlet implementation class ControllerUsingURI
 */
//@WebServlet("/ControllerUsingURI") // web.xml에서 대신 설정함

//아래 if 문으로 분기를 나누는것도 mvc 모델이기는 하다. 하지만 mvc 모델이 추구하는 규격은 아님
//if(command.equals("/login.do")) {
//	
//}else if (command.equals("/main.do")) {
//	
//}


public class ControllerUsingURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private CommandFactory commandFactory;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUsingURI() {
        super();
        // 무언가를 생성할 일이 있으면 작성한다. 일반적으로는 작성할 일이 없다.
         commandFactory =new CommandFactory();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("어떤명령어가 날아왔는 지 알아야 분기를 시킬 수 있다. :   " + request.getRequestURI() );
											// 웹페이지에서 프로젝트명이 필수로 있어야 명령어가 유효함. contextPath없이 접근이 불가능하다는 뜻임. 톰캣은 여러개의 프로젝트를 실행할 수 있기 때문이다.
		String command = request.getRequestURI();
											//command.substring(12);
											//command.substring("/JSPMVC_0420".length());
		command = command.substring(request.getContextPath().length()); 
											//이렇게해야 프로젝트의 이름 길이와 상관없이 잘라낼 수 있다. 필수는 아님
		System.out.println("명령어 자르기 했음 : "+ command);
		
		CommandHandler handler = commandFactory.getCommandHandler(command); //해쉬맵에서 이 명령어에 맞는 객체를 뽑아온다.
		
		String view = null;
		
		if(handler!=null) {
			view = handler.process(request, response);
		} else {
			System.out.println("[경고] 명령어에 매핑된 객체가 없습니다.");
		} 
		if(view!=null) {
			//예외처리
			if(view.startsWith("redirect:")) {
				view=view.substring("redirect:".length()); //리다이렉트가 있는거라 앞을 잘라준다
				response.sendRedirect(view);
			}else {
				RequestDispatcher dispatcher =  request.getRequestDispatcher(view); //리다이렉트가 없는것
				dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
