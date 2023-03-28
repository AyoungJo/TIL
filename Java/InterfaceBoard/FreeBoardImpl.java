package ex0327.interfaceEx.board;

import java.util.ArrayList;
import java.util.List;

public class FreeBoardImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("FreeBoardImpl의 insert 호출");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("FreeBoardImpl의 update 호출");
		return true;
	}

	@Override
	public Board selectByBno(int bno) {
		System.out.println("FreeBoardImpl의 selectByBno 호출");
		return new Board(bno, "자유 제목1", "작성자5", "자유 내용1");
	}

	@Override
	public List<Board> selectAll() {
		System.out.println("FreeBoardImpl의 selectAll 호출");
		List<Board> list = new ArrayList<>();

		list.add(new FreeBoard(8, "제목8", "작성자8", "자유다"));
		list.add(new FreeBoard(10, "제목10", "작성자10", "자유다2"));

		return list;
	}

	@Override
	public int replyInsert() {
		System.out.println("FreeBoardImpl 의 replyInsert 호출");

		return 3;
	}

}
