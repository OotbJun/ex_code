package com.ja.freeboard.model;

import java.sql.*;
import java.util.*;
import java.util.Date;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.ja.freeboard.vo.*;

public class Memberdao {
// 여기서 쿼리문을 모두 작성한다. 단 메소드명을 잘 지어야함. insert, delete, select 를 작성해줄 dao 이다.
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // @뒤의 localhost 자리에 다른 주소를 넣으면 주소값을 찾아가서
																				// 접속한다.
	private static final String USER = "SCOTT";
	private static final String PASSWORD = "TIGER";

	public void insert(String m_id, String m_pw, String m_nick, String m_phone) {
		// 매개값을 받아야한다.

		String query = "INSERT INTO fb_member VALUES(fb_member_seq.nextval, ?,?,?,?,SYSDATE)";
		// 불완전하게 쿼리문을 만들고 아래 프리페어드 스테이트먼트를 사용하고 예외처리 구문을 통해서 내부적으로 컴파일하고 거기에 맞는 형태대로
		// 쿼리문을 채워준다.

		Connection conn = null;
		PreparedStatement pstm = null; // executeStatement 랑 거의 똑같음.

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 동적으로 로드는 한번 해야함. 클래스가 한번이라도 사용이 되야 load가 된다.
//			oracle.jdbc.driver.OracleDriver temp; 이렇게 작성해도 DB가 로드되고 쿼리문이 정상적으로 실행된다.

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstm = conn.prepareStatement(query);
			pstm.setString(1, m_id);
			pstm.setString(2, m_pw);
			pstm.setString(3, m_nick);
			pstm.setString(4, m_phone);
			// 여기서 숫자는 물음표의 순서를 말함.

			pstm.executeUpdate(); // 쿼리를 네트워크 프로토콜에 의해 전송하는 코드가 여기임.

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (pstm != null) {
				try {
					pstm.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public MemberVo selectByIdAndPw(String id, String pw) {
		// 여기는 db에서 select 만 한다.
		MemberVo memberVo = null;

		String query = "select * from fb_member where m_id = ? and m_pw = ?";

		// select 할때는 3개의 변수가 필요하다.
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, pw);

			rs = pstm.executeQuery(); // 셀렉트 할때는 executeQuery를 쓴다. 리턴타입은 resultset 이다.

			// 여기 아래부터 로직이다.
			if (rs.next()) {
				int m_no = rs.getInt("m_no");
				String m_id = rs.getString("m_id");
				String m_pw = rs.getString("m_pw");
				String m_nick = rs.getString("m_nick");
				String m_phone = rs.getString("m_phone");
				Date m_joindate = rs.getDate("m_joindate");
				
				memberVo = new MemberVo(m_no,m_id,m_pw,m_nick,m_phone,m_joindate);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (pstm != null) {
				try {
					pstm.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return memberVo;
	}

	public MemberVo selectByNo(int no) {
		
		MemberVo memberVo = null;
		
		String query = "select * from fb_member where m_no = ?";

		// select 할때는 3개의 변수가 필요하다.
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, no);

			rs = pstm.executeQuery(); // 셀렉트 할때는 executeQuery를 쓴다. 리턴타입은 resultset 이다.

			// 여기 아래부터 로직이다.
			if (rs.next()) {
				int m_no = rs.getInt("m_no");
				String m_id = rs.getString("m_id");
				String m_pw = rs.getString("m_pw");
				String m_nick = rs.getString("m_nick");
				String m_phone = rs.getString("m_phone");
				Date m_joindate = rs.getDate("m_joindate");
				
				memberVo = new MemberVo(m_no,m_id,m_pw,m_nick,m_phone,m_joindate);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (pstm != null) {
				try {
					pstm.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return memberVo;
		
	}
}
