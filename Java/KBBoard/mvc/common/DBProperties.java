package kb.mvc.common;
/**
 * DB의 설정 정보들 상수로 관리
 * */
public interface DBProperties {
  public static final String DRVIER_NAME="oracle.jdbc.driver.OracleDriver";
   String URL="jdbc:oracle:thin:@localhost:1522:ORCL";
   String USER_ID="";
   String USER_PASS="";
   
}
