package jdbc.app;

import java.util.List;

import jdbc.dao.UserDAO;
import jdbc.dao.UserDAOimpl;
import jdbc.dto.UserDto;

public class Test {
	static UserDAO userdao;

	public static void main(String[] args) {

		userdao = new UserDAOimpl();
		// #1. users table 에 insert 1건 처리를 위해 insert() 를 완성한다
		insert(userdao);

		// #2. users table 에 update 1건 처리를 위해 update() 를 완성한다.
		update(userdao);

		// #3. users table 을 전체 조회, 출력하는 selectAll() 를 완성한다.
		selectAll();

		// #4. users table 을 user_seq 로 1건 조회, 출력하는 selectOne() 를 완성한다.
		selectOne(userdao);

		// #5. users table 을 user_seq 로 1건 삭제하는 delete() 를 완성한다.
		delete(userdao);

	}

	static void insert(UserDAO dao) {
		UserDto userDto = new UserDto();
		userDto.setUserSeq(666);
		userDto.setName("육길동");
		userDto.setEmail("six@gildong@com");
		userDto.setPhone("010-6666-6666");
		userDto.setSleep(false);

		dao.insert(userDto);
	}

	static void update(UserDAO dao) {
		UserDto userDto = new UserDto();
		userDto.setUserSeq(666);
		userDto.setName("육길동");
		userDto.setEmail("yook@gildong@com");
		userDto.setPhone("010-7777-7777");
		userDto.setSleep(true);

		// dao호출하고 그결과에 따라 출력한다.
		dao.update(userDto);
	}

	static void selectAll() {

		List<UserDto> list = userdao.selectAll();
		for (UserDto udto : list) {
			System.out.println(udto);
		}
	}

	static void selectOne(UserDAO dao) {
		int userSeq = 666;

		UserDto list = dao.selectOne(userSeq);
		System.out.println(list);
	}

	static void delete(UserDAO dao) {
		int userSeq = 666;

		dao.delete(userSeq);

	}
}
