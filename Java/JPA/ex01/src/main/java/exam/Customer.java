//MainApp.java에서 실행
package exam;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder //원하는 컬럼만 지정해서 생성 
@ToString
public class Customer {

	@Id //pk
	@GeneratedValue(strategy = GenerationType.AUTO) //시퀀스 생성 동일
	private Long id;
	
	@Column(nullable = false, length=100, name = "user_name")
	private String userName;	//Not Null
	
	//@Transient //필드 컬럼으로 생성 X
	@Column(nullable = true)
	private int age;
	
	@CreationTimestamp
	private LocalDateTime insertDate;	//등록일
	
	@UpdateTimestamp
	private LocalDateTime updateDate;	//수정일
	
	@Temporal(TemporalType.DATE)
	private Date birthDay;	
	
}
