package ex0327.interfaceEx.board;

import java.util.ArrayList;
import java.util.List;

public class UploadBoardImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("UploadBoardImpl의 insert 호출");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("UploadBoardImpl의 update 호출");
		return true;
	}

	@Override
	public Board selectByBno(int bno) {
		System.out.println("UploadBoardImpl의 selectByBno 호출");
		return new Board(bno, "올릴 제목", "작성자", "올릴 내용");
	}

	@Override
	public List<Board> selectAll() {
		System.out.println("UploadBoardImpl의 selectAll 호출");
		List<Board> list = new ArrayList<>();

		list.add(new UploadBoard(3, "제목3", "작성자3", "내용3", "알고리즘_수업자료.pdf"));
		list.add(new UploadBoard(4, "제목4", "작성자4", "내용4", "자바_수업자료.pdf"));

		return list;
	}

}
