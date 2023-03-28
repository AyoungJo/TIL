package ex0327.interfaceEx.board;

import java.util.ArrayList;
import java.util.List;

/**
 * QA에 관련된 비즈니스 로직(주요 기능)
 */
public class QABoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("QABoardServiceImpl의 insert 호출");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("QABoardServiceImpl의 update 호출");
		return true;
	}

	@Override
	public Board selectByBno(int bno) {
		System.out.println("QABoardServiceImpl의 selectByBno 호출");
		return new Board(bno, "찾은 제목", "찾은_작성자", "찾은_내용");
	}

	@Override
	public List<Board> selectAll() {
		System.out.println("QABoardServiceImpl의 selectAll 호출");
		List<Board> list = new ArrayList<>();
		list.add(new QABoard(1, "제목1", "작성자1", "내용1", true));
		list.add(new QABoard(2, "제목2", "작성자2", "내용2", true));

		return list;
	}

}
