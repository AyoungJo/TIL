package ex0327.interfaceEx.board;

import java.util.ArrayList;
import java.util.List;

public class TestMainApp {
	BoardService service; // null -> 필드를 이용한 다형성
	Board board;

	public static void main(String[] args) {
		new TestMainApp();
	}

	// 메인 메서드에서 static을 호출하지 못하기 때문에 생성자를 통해 호출
	public TestMainApp() {
		// test 메소드 호출
		System.out.println("********* QABoard TEST ********");
		service = new QABoardServiceImpl(); // 실제로 객체를 생성하는 것은 Impl
		board = new QABoard(1, "title", "writer", "content", false);

		this.test(service, board);

		System.out.println("********* FreeBoard TEST ********");
		service = new FreeBoardImpl();
		board = new FreeBoard(10, "free 제목", "free 작성자", "free 내용");
		this.test(service, board);

		System.out.println("********* Upload TEST ********");
		service = new UploadBoardImpl();
		board = new UploadBoard(2, "Upload 제목", "Upload 작성자", "Upload 내용", "Upload.zip");
		this.test(service, board);

		// 익명 구현 클래스
		service = new BoardService() {

			@Override
			public int insert(Board board) {
				System.out.println("PhotoService insert");
				return 0;
			}

			@Override
			public boolean update(Board board) {
				System.out.println("PhotoService update");
				return false;
			}

			@Override
			public Board selectByBno(int bno) {
				System.out.println("PhotoService selectByBno");
				return null;
			}

			@Override
			public List<Board> selectAll() {
				System.out.println("PhotoService selectAll");
				return new ArrayList<>();
			}

		};

		this.test(service, board);
	}

	/**
	 * 인수로 전달된 BoardService를 이용해서 각 메소드(XxxService)를 호출해보자.
	 */
	public void test(BoardService service, Board board) { // QA, Free, Upload 가능
		service.insert(board);
		service.update(board);

		service.selectByBno(0);
		service.selectAll();

		Board searchBoard = service.selectByBno(1);
		System.out.println("searchBoard = " + searchBoard);

		List<Board> list = service.selectAll();
		System.out.println("검색된 레코드 : " + list.size());
		for (Board b : list) {
			System.out.println(b);
		}

		System.out.println("---------------추가 메소드 호출---------------");
		service.replyInsert();
		BoardService.selectBySubject(); // static 메소드
	}

}
