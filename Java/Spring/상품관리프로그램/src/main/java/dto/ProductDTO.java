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
public class ProductDTO {
   private String code;   
   private String name;   
   private int price;
   private String detail;
   
	public ProductDTO(String code) {
		this.code =code;
	}
   
}
