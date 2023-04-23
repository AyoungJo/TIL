package dao;

import dto.UserDto;

public interface UserDao {
	int register(UserDto userDto);
	boolean confirmPassword(int userSeq, String password);
	int changePassword(int userSeq, String password);
}
