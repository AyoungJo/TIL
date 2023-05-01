package common;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis ORM 설정 세팅
 * */
public class DBManager {
	private static SqlSessionFactory factory;
	
  static {
	  try {
		 //SqlSessionFactoryBuilder를 이용해서 SqlSessionFactory를 생성한다.
		  String resource = "SqlMapConfig.xml";
		  Reader reader = Resources.getResourceAsReader(resource);
		  
		  factory =  new SqlSessionFactoryBuilder().build(reader);
		  
	  }catch (Exception e) {
		e.printStackTrace();
	 }
	  
   }//static End
  
  /**
   * SqlSession객체를 리턴해주는 메소드 작성 - JDBC의 Connection과 동일한 역할
   *   : SqlSession는 CRUD작업을 할때마다 새롭게 생성하고 닫기해준다.
   *   : commit 또는 rollback를 이용해서 transaction 처리를한다.
   *   : 자동커밋이 아니기때문에 DML(Insert, Update, Delete)작업인 경우 반드시 저장 또는 취소 필수!!
   * */
  public static SqlSession getSession() {
	  return factory.openSession();
  }
  
  /**
   * 닫기 기능(select전용)
   * */
   public static void sessionClose(SqlSession session) {
	   if(session!=null)session.close();
   }
  
  /**
   * 닫기 기능(DML전용)
   *  @param : boolean의 state는 true인경우에 commit() , false인경우 rollback() 
   * */
   public static void sessionClose(SqlSession session , boolean state) {
	    if(session!=null) {
	    	if(state)session.commit();
	    	else session.rollback();
	    	
	    	session.close();
	    }
   }
   
	/*
	 * public static void main(String[] args) {
	 * System.out.println("---시작합니다.------"); SqlSession session =
	 * DBManager.getSession(); System.out.println("session = " + session ); }
	 */
   
}
