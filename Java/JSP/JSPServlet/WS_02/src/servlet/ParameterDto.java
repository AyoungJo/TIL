package servlet;

import java.util.Arrays;

public class ParameterDto {	

	private String name;
	private String email;
	private String gender;
	private String[] hobby;
	private String favorite;
	private String desc;
	
	public ParameterDto() {}
	public ParameterDto(String name, String email, String gender, String[] hobby, String favorite, String desc) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.hobby = hobby;
		this.favorite = favorite;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(hobby);
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
