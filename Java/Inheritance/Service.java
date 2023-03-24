package ex0324;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 상속과 생성자 
 * Service SpiderMain or Person 객체를 관리 (CRUD)
 */
public class Service {

	List<Person> list = new ArrayList<>();

	/**
	 * 샘플 데이터 추가 기능
	 */
	public Service() {
		// 객체를 생성해서 list 추가해보자.
		list.add(new SpiderMan("토비", 24, true));
		list.add(new SpiderMan("앤드류", 21, false));
		list.add(new SpiderMan("톰", 18, true));

		list.add(new Student("학생1", 12, 1));
		list.add(new Student("학생2", 20, 5));
		list.add(new Student("학생3", 25, 3));
	}

	/**
	 * 전체 조회(등록순)
	 */
	public List<Person> selectAll() {
		return list;
	}

	/**
	 * 등록하기 - 등록 성공여부 리턴타입 있어야 함 해당 메서드에서는 리턴타입 없이 선언
	 */
	public void insert(Person person) {
		list.add(person);
	}

	/**
	 * 인수로 전달된 name에 해당하는 사람의 정보 조회 (name 중복 안됨)
	 * 
	 * @return : null이면 해당 정보가 없다, 아니면 찾았다
	 */
	public Person selectByName(String name) {

		for (Person p : list) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * 인수로 전달된 name에 해당하는 정보 삭제하기
	 * 
	 * @return : true 이면 삭제 성공, false 이면 삭제 실패
	 */
	public boolean deleteByName(String name) {

		Person p = this.selectByName(name);

		return list.remove(p);

//		boolean result = list.remove(p);
//		return result;
	}

	/**
	 * 나이를 기준으로 정렬해서 조회하기
	 */
	public List<Person> sortByAge() {
		// 정렬해서 담을 객체 필요
		ArrayList<Person> sortedList = (ArrayList<Person>)list;
		sortedList = (ArrayList<Person>)list;		

		sortedList.sort((o1, o2) -> o1.getAge() - o2.getAge());

		return sortedList;
	}
}
