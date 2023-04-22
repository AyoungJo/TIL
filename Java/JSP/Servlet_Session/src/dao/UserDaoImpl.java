package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.DBManager;
import dto.UserDto;

public class UserDaoImpl implements UserDao{

	private static UserDao instance = new UserDaoImpl();
	
	private UserDaoImpl() {}
	
	public static UserDao getInstance() {
		return instance;
	}
	
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

}
