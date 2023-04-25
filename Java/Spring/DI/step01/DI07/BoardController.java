package sample07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
//@Controller("controller") //id="controller"
public class BoardController {
	@Autowired //byType 주입
	private BoardService boardService;
	
	@Autowired
	private BoardDTO boardDTO;
	
	@Autowired
	private BoardDTO boardDTO2;
	
	public BoardController() {
		System.out.println("BoardController() 생성자 호출");
	}
	public void test() {
		System.out.println("boardDTO = " + boardDTO + ", subject : " + boardDTO.getSubject());
		System.out.println("boardDTO2 = " + boardDTO2 + ", subject : " + boardDTO2.getSubject());
		System.out.println("boardService = " + boardService);
		System.out.println("========================");
		boardService.select();
	}

}
