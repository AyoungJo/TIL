package kb.mvc.exception;

/**
 * insert, update, delete 에 결과가 오류가 있을 때 발생시킬 예외
 */
public class DMLException  extends RuntimeException{
	public DMLException() {}
	public DMLException(String message) {
		super(message);
	}

}
