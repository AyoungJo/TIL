package kb.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	/**
	 * 로드
	 */
	static {
		try {
			Class.forName(DBProperties.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 연결
	 */

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DBProperties.URL, DBProperties.USER_ID, DBProperties.USER_PW);
	}

	/**
	 * 닫기(DML 전용) 예외 직접 처리
	 */
	public static void releaseConnection(Connection con, Statement st) {
		// 사용됐을 경우만 close - close 순서 중요
		// null 인 상태에서 close 한다면 NullPointerException 발생할 수 있음

		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 닫기(select 전용) - Resultset(결과값 반환)
	 */
	public static void releaseConnection(Connection con, Statement st, ResultSet rs) {

		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 예외 처리 하기 때문에 해당 메서드에서 예외처리 중복 X
		releaseConnection(con, st);
	}

}
