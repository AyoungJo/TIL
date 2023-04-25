package sample03;

public class BookDAOImpl implements BookDAO {
    public BookDAOImpl() {
    	System.out.println("BookDAOImpl의 기본생성자 ");
    }
    
    @Override
	public void insert(BookVo bookVo) {
		System.out.println("BookDAOImpl의 INSERT 호출됨!");
		System.out.println("책제목 : " + bookVo.getSubject());
		System.out.println("작성자 : " + bookVo.getWriter());
		System.out.println("가격 : " + bookVo.getPrice());
		System.out.println("날짜 : " + bookVo.getDate());
		
	}	

}
