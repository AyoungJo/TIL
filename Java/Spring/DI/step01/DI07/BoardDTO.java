package sample07;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
//@NoArgsConstructor	//인수 없는 생성자
@AllArgsConstructor	//모든 인수를 담은 생성자
@Component	//id="boardDTO"
@Scope("prototype")	//지연초기화 - 동일한 객체를 여러개 만들고 싶을 때 선언
public class BoardDTO {
	@Value("10")
	private int no;
	
	@Value("SpringDI")
	private String subject;
	
	@Value("스프링DI 학습")
	private String content;
	
	public BoardDTO() {
		System.out.println("BoardDTO() 생성자 호출");
	}
}
