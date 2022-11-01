package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	
	public static Connection getConnection() throws Exception{
		
		Connection conn = null;
		Context initContext = new InitialContext();	//네이밍 조작을 위한 클래스 객체 생성
		Context envContext  = (Context)initContext.lookup("java:/comp/env");	// 지정한 이름 찾기
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");	// 지정한 이름 찾기
		conn = ds.getConnection();
		
		return conn;
	}
	
	//select을 수행한 후 리소스를 해제를 위한 메소드 생성
	//Statement객체 : 정적인 쿼리문 처리할 수 있는객체, 반드시 값이 미리 입력되어있을때 사용가능
	//PreparedStatement : 쿼리문 저장
	
	public static void close(Connection conn,Statement stmt,ResultSet rs) {
		
		try {
			conn.close();
			stmt.close();
			rs.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	public void close(Connection conn, Statement stmt){
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
