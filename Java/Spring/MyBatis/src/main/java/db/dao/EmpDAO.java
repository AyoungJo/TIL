package db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import db.common.DBManager;
import db.dto.EmpDTO;

public class EmpDAO {
	
	/**
	 * 사원 이름 검색
	 */
	public void selectByEname() {
		SqlSession session = null;
		try {
			//로드 연결 실행 닫기 
			session = DBManager.getSession();
			List<String> list = session.selectList("empMapper.selectName");
			System.out.println("list = " + list);
		} finally {
			DBManager.sessionClose(session);
		}
	}
	
	/**
	 * 사원 등록
	 * @param empDTO
	 */
	public void insert(EmpDTO empDTO) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DBManager.getSession();
			state = session.insert("empMapper.insert", empDTO) > 0 ? true : false;
			System.out.println("state = " + state);
		} finally {
			DBManager.sessionClose(session, state);
		}
	}
	
	/**
	 * 사원 삭제
	 * @param empno
	 */
	public void delete(int empno) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DBManager.getSession();
			state = session.delete("empMapper.delete", empno) > 0 ? true : false;
			System.out.println("state = " + state);
		} finally {
			DBManager.sessionClose(session, state);
		}
	}
	
	public void selectOrder(String columnName) {
		SqlSession session = null;
		try {
			//로드 연결 실행 닫기 
			session = DBManager.getSession();
			List<EmpDTO> list = session.selectList("empMapper.selectByOrder" , columnName);//id="namespace이름.id"
			//System.out.println("list = " + list);
			for(EmpDTO dto :list) {
				System.out.println(dto);
			}
		} finally {
			DBManager.sessionClose(session);
		}
	}
}
