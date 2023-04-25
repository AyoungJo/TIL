package sample03;

public class BookController { //<bean 
	private BookDAO bookDao;//null
	private BookVo bookVo;//null
	
    public BookController(){}
	
	public BookController(BookDAO bookDao, BookVo bookVo) { //ref="" 
		System.out.println("BookController(BookDAO bookDao, BookVo bookVo) 호출");
		this.bookDao = bookDao;
		this.bookVo = bookVo;
	}

	public void bookInsert(){
		bookDao.insert(bookVo);
	}
	
}
