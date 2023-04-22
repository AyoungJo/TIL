package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;


public class BannerDaoImpl implements BannerDAO {

	@Override
	public List<String> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<String> list = new ArrayList<>();
		String sql = "select * from banner";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()){
				String banner = rs.getString(1);
				list.add(banner);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

}
