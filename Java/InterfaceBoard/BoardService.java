package ex0327.interfaceEx.board;

import java.util.List;

/**
 * 모든 게시물의 공통으로 사용하게 될 메소드 정의(규격서)
 */
public interface BoardService {

	/**
	 * 등록하기
	 * 
	 * @return : 0이면 등록 실패, 1이상이면 등록 성공
	 */
	int insert(Board board);

	/**
	 * 수정하기(글번호에 해당하는 제목, 내용 수정)
	 */
//	boolean update(int bno, String subject, String content);
	boolean update(Board board);

	/**
	 * 글번호에 해당하는 게시물 조회하기(글번호 중복 불가)
	 */
	Board selectByBno(int bno);

	/**
	 * 전체 게시물 조회하기
	 */
	List<Board> selectAll();

	default int replyInsert() {
		System.out.println("BoardService 의 replyInsert 호출");
		return 1;
	}

	static Board selectBySubject() {
		System.out.println("BoardService 의 selectBySubject 호출");
		return null;
	}

}
