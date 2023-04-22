package service;

import dao.LoginDao;
import dao.LoginDaoImpl;
import dto.UserDto;

public class LoginServiceImpl implements LoginService {
	private LoginDao dao = new LoginDaoImpl();

	@Override
	public UserDto login(String email, String password) {
		
		UserDto udto = dao.login(email);
		
		if(udto != null && udto.getPassword().equals(password)) {
			//로그인 성공시 세션에 비밀번호가 공개되는 것을 막기 위해 null 처리
			udto.setPassword(null); 
			return udto;
		}else {			
			return null;
		}
		
	}

}
