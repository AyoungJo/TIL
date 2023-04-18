package web.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * JDBC를 위한 로드, 연결, 닫기
 */
public class DBManager {

	private static DataSource ds;
	/**
	 * 로드
	 */
	static {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			 ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * 연결 -> conncection은 공유하지 않는다.
	 * context.xml에서 DBCP 기술 설정 부분의  maxTotal
	 */
	public static Connection getConnection() throws SQLException {
	
		return ds.getConnection();
	}

	/**
	 * 닫기(DML 전용). 사용된 객체를 닫는 것
	 */
	public static void releaseConnection(Connection con, Statement st) {
		try {
			if (st != null) st.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 닫기(SELECT 전용)
	 */
	public static void releaseConnection(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		releaseConnection(con, st);
	}
}
