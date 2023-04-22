package service;

import dto.UserDto;

public interface LoginService {

	UserDto login(String email, String password);
}
