package com.ja.freeboard.model;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.ja.freeboard.vo.*;

public class Boarddao {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "SCOTT";
	private static final String PASSWORD = "TIGER";
	
	public ArrayList<BoardVo> selectAll() {
		
		ArrayList<BoardVo> list = new ArrayList<BoardVo>(); 
		//결과와 있건 없건 만들어야 한다. 비어있는 상태여도 있어야함.
		//리턴값이 null 이 되면 안된다.
		
		String query = "select * from fb_board order by b_no desc";

		// select 할때는 3개의 변수가 필요하다.
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstm = conn.prepareStatement(query);
			
			rs = pstm.executeQuery(); // 셀렉트 할때는 executeQuery를 쓴다. 리턴타입은 resultset 이다.

			// 여기 아래부터 로직이다.
			while(rs.next()) {
				//한번 돌때마다 갈 row 의 데이터를 가져와야한다.
				int b_no = rs.getInt("b_no");
				int m_no = rs.getInt("m_no");
				String b_title = rs.getString("b_title");
				String b_content = rs.getString("b_content");
				Date b_writedate = rs.getDate("b_writedate");
				
				//돌고나면 이 데이터를 vo에 넣어주고 list에 add 한다.
				BoardVo boardVo = new BoardVo(b_no,m_no,b_title,b_content,b_writedate);
				
				list.add(boardVo);
												
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
		

		return list;
		
	}

	public void delete(int no) {
		//삭제도 pk를 중심으로 하는게 좋다,
		String query = "DELETE FROM fb_board WHERE B_NO = ?";

		Connection conn = null;
		PreparedStatement pstm = null; // executeStatement 랑 거의 똑같음.

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, no);  //메소드에서 선언된 자료형과 변수 명을 작성해준다. 

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
	
	public void update(int no, String title, String content) {
		String query = "UPDATE fb_board set b_title = ?, b_content = ? WHERE b_no = ?";

		Connection conn = null;
		PreparedStatement pstm = null; // executeStatement 랑 거의 똑같음.

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstm = conn.prepareStatement(query);
			pstm.setString(1, title);  //메소드에서 선언된 자료형과 변수 명을 작성해준다. 
			pstm.setString(2, content);  //메소드에서 선언된 자료형과 변수 명을 작성해준다.
			pstm.setInt(3, no);  //메소드에서 선언된 자료형과 변수 명을 작성해준다.
//			pstm.setString(3, ""+no);  //이렇게 해도 된다. 숫자를 문자열로 바꿔주는거임
			
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
	
	public void insert(int memberno, String title, String content) {
		String query = "insert into fb_board values(FB_BOARD_SEQ.nextval, ?, ?, ?, sysdate)";

		Connection conn = null;
		PreparedStatement pstm = null; // executeStatement 랑 거의 똑같음.

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, memberno);
			pstm.setString(2, title);  //메소드에서 선언된 자료형과 변수 명을 작성해준다. 
			pstm.setString(3, content);  //메소드에서 선언된 자료형과 변수 명을 작성해준다.
			  //메소드에서 선언된 자료형과 변수 명을 작성해준다.
			
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
	
//	여기까지의 코드는 ResultSet이 필요없기때문에 실행문 작성이 비슷하다. 변수만 제대로 작성해주면 됨 
		
	public BoardVo selectByNo(int no) {
		BoardVo boardVo = null;
		//변수는 초기화 해준다. 
		
		String query = "select * from fb_board where b_no = ?";

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
			if(rs.next()) {
				int b_no = rs.getInt("b_no"); // 컬럼명으로 가져오는 것이 좋다
				int m_no = rs.getInt("m_no");
				String b_title = rs.getString("b_title");
				String b_content = rs.getString("b_content");
				java.util.Date b_writedate = rs.getDate("b_writedate");
				
				boardVo = new BoardVo(b_no, m_no, b_title, b_content, b_writedate);
				
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
		return boardVo;
	}
}
