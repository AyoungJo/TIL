package exam;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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
@Builder
//@ToString
public class Team {

	@Id	//pk
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_pk")	//자동 시퀀스 생성
	@SequenceGenerator(name = "team_pk", allocationSize = 1, sequenceName = "team_pk")
	//GenerationType.SEQUENCE 작성시 @SequenceGenerator와 함께 사용해주어야 한다. 
	private Long id;
	private String teamName;

	@OneToMany(mappedBy = "team", fetch=FetchType.EAGER)
	//@OneToMany(mappedBy = "team")	//join 대상 설정, 지연로딩이지만 ToString으로 인해 가져와짐
	private List<Member> memberList;
}
