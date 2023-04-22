package service;

import dao.UserDao;
import dao.UserDaoImpl;
import dto.UserDto;

public class UserServiceImpl implements UserService{

	private static UserService instance = new UserServiceImpl();
	
	private UserDao userDao = UserDaoImpl.getInstance();
	
	private UserServiceImpl() {}
	
	public static UserService getInstance() {
		return instance;
	}
	
	@Override
	public int register(UserDto userDto) {
		return userDao.register(userDto);
	}

}
