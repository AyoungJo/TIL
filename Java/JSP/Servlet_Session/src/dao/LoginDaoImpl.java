package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBManager;
import dto.UserDto;

public class LoginDaoImpl implements LoginDao {

	@Override
	public UserDto login(String email) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserDto udto = null;
		
		String sql = "select user_seq, name, password, email, phone, is_sleep from users where email = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, email);
			rs= ps.executeQuery();
			if(rs.next()) {
				udto = new UserDto();
				udto.setUserSeq(rs.getInt("user_seq"));
				udto.setName(rs.getString("name"));
				udto.setPassword(rs.getString("password"));
				udto.setEmail(rs.getString("email"));
				udto.setPhone(rs.getString("phone"));
				udto.setSleep(( "Y".equals(rs.getString("is_sleep"))));
			}			

		} catch (SQLException e) {
			e.printStackTrace();
			//userDto = null;
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return udto;
	}

}
