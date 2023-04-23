package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBManager;
import dto.UserDto;

public class UserDaoImpl implements UserDao{

	private static UserDao instance = new UserDaoImpl();
	
	private UserDaoImpl() {}
	
	public static UserDao getInstance() {
		return instance;
	}
	
	/**
	 * 회원가입
	 */
	@Override
	public int register(UserDto userDto) {
		String sql = "insert into users (user_seq, name, email, phone, password) values (user_seq.nextval, ?, ?, ?, ?) ";
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = 0;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userDto.getName());
			pstmt.setString(2, userDto.getEmail());
			pstmt.setString(3, userDto.getPhone());
			pstmt.setString(4, userDto.getPassword());
			
			ret = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, pstmt);
		}
		
		return ret;
	}
	
	/**
	 * 비밀번호 일치 여부 확인
	 */
	public boolean confirmPassword(int userSeq, String password) {
		String sql = "select password from users where user_seq = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean result = false;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userSeq);
			
			rs = pstmt.executeQuery();

			if(rs.next()) {
				String pw = rs.getString("password");
				if(password.equals(pw)) {
					result = true;
				}				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, pstmt);
		}
		
		return result;
	}
	
	/**
	 * 비밀번호 변경
	 */
	public int changePassword(int userSeq, String password) {
		String sql = "update users set password = ? where user_seq = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, password);
			pstmt.setInt(2, userSeq);		

			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, pstmt);
		}
		
		return result;
	}

}
