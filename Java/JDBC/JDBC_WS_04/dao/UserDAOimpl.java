package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dto.UserDto;

public class UserDAOimpl implements UserDAO {

	@Override
	public int insert(UserDto userDto) {
		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;
		String sql = "insert into users(user_seq, name, email, phone, is_sleep) values (?,?,?,?,?)";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, userDto.getUserSeq());
			ps.setString(2, userDto.getName());
			ps.setString(3, userDto.getEmail());
			ps.setString(4, userDto.getPhone());

			if (userDto.isSleep() == false) {
				ps.setLong(5, 'N');
			} else {
				ps.setLong(5, 'Y');
			}
			result = ps.executeUpdate();
			System.out.println("회원 생성에 성공하였습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int update(UserDto userDto) {
		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;
		String sql = "update users set name = ?, email = ?, phone = ?, is_sleep = ? where user_seq = ?";

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, userDto.getName());
			ps.setString(2, userDto.getEmail());
			ps.setString(3, userDto.getPhone());
			ps.setLong(4, 'N');
			if (userDto.isSleep() == false) {
				ps.setLong(4, 'N');
			} else {
				ps.setLong(4, 'Y');
			}
			ps.setInt(5, userDto.getUserSeq());

			result = ps.executeUpdate();
			System.out.println("회원 정보 수정이 완료되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public List<UserDto> selectAll() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		UserDto udto = null;
		List<UserDto> list = new ArrayList<>();
		String sql = "select user_seq, name, email, phone, is_sleep from users";

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery(); // 쿼리 결과를 ResultSet에 저장

			while (rs.next()) {
				int user_seq = rs.getInt("user_seq");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");

				boolean is_sleep = false;
				if (rs.getString("is_Sleep").equals("Y")) {
					is_sleep = true;
				} else {
					is_sleep = false;
				}
				udto = new UserDto(user_seq, name, email, phone, is_sleep);
				list.add(udto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}

		return list;
	}

	@Override
	public UserDto selectOne(int userSeq) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		UserDto udto = null;

		String sql = "select user_seq, name, email, phone, is_sleep from users where user_seq = ?";

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, userSeq);

			rs = ps.executeQuery();

			while (rs.next()) {
				int user_seq = rs.getInt("user_seq");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");

				boolean is_sleep = false;
				if (rs.getString("is_Sleep").equals("Y")) {
					is_sleep = true;
				} else {
					is_sleep = false;
				}
				udto = new UserDto(user_seq, name, email, phone, is_sleep);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}

		return udto;
	}

	@Override
	public int delete(int userSeq) {
		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;
		String sql = "delete from users where user_seq = ?";

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, userSeq);

			result = ps.executeUpdate();
			System.out.println("회원 정보가 삭제되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

}
