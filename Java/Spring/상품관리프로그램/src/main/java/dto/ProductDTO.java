package web.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor //final or @NonNull 필드값만 파라미터로 받는 생성자 생성
public class ProductDTO {
   private String code;   
   private String name;
   
   @NonNull
   private int price;
   private String detail;
   
   public ProductDTO(String code) {
	this.code =code;
   }
   
}
