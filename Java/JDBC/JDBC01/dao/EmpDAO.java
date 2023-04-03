package kb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kb.common.DBManager;
import kb.dto.EmpDTO;

public class EmpDAO {

	/**
	 * emp 테이블의 사원 정보 검색하기 select empno, ename, job, sal, hiredate from emp;
	 */
	public void selectAll() {
		// Connection 공유하는 것이 아니기 때문에 전역변수로 선언하면 안됨.
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select empno, ename, job, sal, hiredate from emp";

		try {
			// 로드 연결 실행 닫기
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery(); // 쿼리 결과를 ResultSet에 저장

			while (rs.next()) { // 다음 행을 조회한다.
				// 다음 열을 조회한다.
				int empno = rs.getInt("empno"); // 컬럼명 대소문자 구분 X
				String ename = rs.getString("ename");
				String job = rs.getString(3);
				int sal = rs.getInt(4);
				String hiredate = rs.getString(5);

				System.out.println(empno + " | " + ename + " | " + job + " | " + sal + " | " + hiredate);
			}
			System.out.println("================완료================");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
	}// selectAll() end

	/**
	 * 사원 등록하기1 insert into emp(empno, ename, job, sal, hiredate) values
	 * (?,?,?,?,sysdate);
	 */
	public void insert() {
		int insertCount = 0;

		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into emp(empno, ename, job, sal, hiredate) values (?,?,?,?,sysdate)";

		try {
			// 로드 연결 실행 닫기
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, 1234);
			ps.setString(2, "JOY");
			ps.setString(3, "MANAGER");
			ps.setInt(4, 2000);

			ps.executeUpdate();
//			insertCount =;			
			System.out.println("사원 등록에 성공했습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}

	}

	/**
	 * 사원 등록하기2 insert into emp(empno, ename, job, sal, hiredate) values
	 * (?,?,?,?,sysdate);
	 * 
	 * @return : insert 성공 하면 숫자 1 리턴
	 */
	public int insert(EmpDTO emp) {
		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;
		String sql = "insert into emp(empno, ename, job, sal, hiredate) values (?,?,?,?,sysdate)";

		try {
			// 로드 연결 실행 닫기
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, emp.getEmpNo());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getSal());

			result = ps.executeUpdate();
			System.out.println("사원 등록에 성공했습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;

	}

}
