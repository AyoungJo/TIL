package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.DBManager;
import dto.ProductDto;

public class ProductDAO {
	
	/**
	 * 상품 등록
	 * @param pdto
	 */
	public void insert(ProductDto pdto) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DBManager.getSession();
			state = session.insert("productMapper.insert", pdto) > 0 ? true : false;
			System.out.println("state = " + state);
		} finally {
			DBManager.sessionClose(session, state);
		}				
	}
	
	/**
	 * 상품 전체 검색
	 */
	public void selectAll() {
		SqlSession session = null;
		try {
			session = DBManager.getSession();
			List<String> list = session.selectList("productMapper.selectAll");
			System.out.println("list : " + list);
		} finally {
			DBManager.sessionClose(session);
		}
	}

	/**
	 * code 와 일치하는 상품 검색 
	 * @param code
	 */
	public void selectOne(String code) {
		SqlSession session = null;
		try {
			session = DBManager.getSession();
			List<String> list = session.selectOne("productMapper.selectOne", code);
			System.out.println("list = " + list);

		} catch (Exception e) {
			DBManager.sessionClose(session);
		}		
	}

	/**
	 * 정렬
	 * @param columnName
	 */
	public void selectOrder(String columnName) {
		SqlSession session = null;
		try {
			session = DBManager.getSession();
			List<ProductDto> list = session.selectList("productMapper.selectOrder" , columnName);
			for(ProductDto dto :list) {
				System.out.println(dto.getName());
			}
			
		} catch (Exception e) {
			DBManager.sessionClose(session);
		}
	}
	
	/**
	 * 상품 등록
	 * @param pdto
	 */
	public void update(ProductDto pdto) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DBManager.getSession();
			state = session.update("productMapper.update", pdto) > 0 ? true : false;
			System.out.println("state = " + state);
		} finally {
			DBManager.sessionClose(session, state);
		}				
	}

	/**
	 * 상품 삭제
	 * @param code
	 */
	public void delete(String code) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DBManager.getSession();
			state = session.delete("productMapper.delete", code) > 0 ? true : false;
		} finally {
			DBManager.sessionClose(session, state);
		}	
	}

	
	public int selectBySum(String columnName) {
		SqlSession session = null;
		int result = 0;
		try {
			session = DBManager.getSession();
			result = session.selectOne("productMapper.selectBySum", columnName);
			System.out.println("합계 = " + result);
		} finally {
			DBManager.sessionClose(session);
		}		
		return result;
	}

}
