package dto;

/**
 * 고객 클래스
 */
public class UserDto {
	private int userSeq; // 고객 일련번호
	private String name; // 이름
	private String email; // 이메일
	private String phone; // 연락처
	private boolean isSleep; // 휴면고객여부

	public UserDto() {
	}

	public UserDto(int userSeq, String name, String email, String phone, boolean isSleep) {
		this.userSeq = userSeq;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.isSleep = isSleep;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isSleep() {
		return isSleep;
	}

	public void setSleep(boolean isSleep) {
		this.isSleep = isSleep;
	}

	@Override
	public String toString() {
		return "고객 일련번호 : " + userSeq + " | 이름 : " + name + " | 이메일 : " + email + " | 연락처 : " + phone + " | 휴면고객여부 : "
				+ isSleep;
	}

	public int compareTo(UserDto o1, UserDto o2) {

		return o1.getName().compareTo(o2.getName());
	}
}
