package exam;

import dao.ProductDAO;

public class ProductMainView {
  public static void main(String[] args) {
	  ProductDAO pdao = new ProductDAO();
	  
	  /**
	   * [1]. 레코드 삽입
	   * */
	  System.out.println("=============== [1] 상품 등록 ===============");
	  //pdao.insert(new ProductDto("A06", "빼빼로", 13, 1300, "달콤한 초코코팅" ));
	  //pdao.insert(new ProductDto("A07", "누드빼빼로", 13, 1600, "초코가 안에 쏘옥" ));
	  
	  /**
	   * [2]. 전체 레코드 검색 
	     ex) select * from productList
	     *        
	   * */
	   System.out.println("=============== [2] 모든 상품 검색 ===============");
	   //pdao.selectAll();

      /**
	   * [3]. 검색필드 , 검색단어에 해당하는 레코드 검색
	     ex) select * from productList where 검색필드 like  검색단어
	     *        
	   * */
	   System.out.println("=============== [3] 검색필드, 검색단어에 해당하는 상품 검색 ===============");
	   //pdao.selectOne("A05");

	   /**
	    * [4]. 전달된 컬럼을 기반으로 정렬하기
	    * ex)select *from productList order by 정렬대상
	    */
	  System.out.println("=============== [4] 전달된 컬럼을 기반으로 정렬 ===============");
	  //pdao.selectOrder("name");      
	 
	  /**
	   * [5]. parameter 정보에 따라 레코드 수정한다.
	   *     상품코드에 해당하는 상품의 
	   *     상품이름, 상품수량, 상품가격, 상품상세정보를 수정 
	   * */
	  System.out.println("=============== [5] 상품 수정 ===============");
	  //pdao.update(new ProductDto("A06", "아몬드빼빼로", 10, 1800, "아몬드 콕콕"));
	  
	  /**
	   * [6].상품코드에 해당하는 레코드 삭제
	   * */
	  System.out.println("=============== [6] 상품 삭제 ===============");
	  //pdao.delete("A06");
	  
	 /**
	  * [7]. 모든 레코드 개수를 출력
	  * */
	  System.out.println("=============== [7] 등록된 상품 총 개수 ===============");
	  pdao.selectBySum("qty");

  }
}
