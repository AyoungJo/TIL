package ex0328.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashMapExam {
//	Map<Integer, String> map =  new HashMap<>();
	Map<Integer, String> map = new TreeMap<>(); // key 정렬

	// key는 중복 불가, value는 중복 가능(key가 같으면 update)
	public HashMapExam() {
		map.put(10, "미니");
		map.put(20, "예삐");
		map.put(40, "아영");
		map.put(30, "아영");
		map.put(50, "미남이");
		map.put(40, "두부");
		map.put(60, "콩이");

		System.out.println("개수 : " + map.size());
		System.out.println(map);

		System.out.println("----- 제거 후 조회 하기 -----");
		map.remove(60);

		System.out.println("개수 : " + map.size());
		System.out.println(map);

		System.out.println("----- 조회 하기 -----");
		// 모든 key의 정보를 가져온다.
		// set은 순서는 없지만 중복 불가능
		Set<Integer> keySet = map.keySet();

		Iterator<Integer> it = keySet.iterator();
		while (it.hasNext()) {
			int key = it.next();
			String value = map.get(key);
			System.out.println(key + " = " + value);
		}

		System.out.println("----- 개선된 for 변경 -----");
		for (Integer key : map.keySet()) {
			String value = map.get(key);
			System.out.println(key + " = " + value);
		}

		System.out.println("\n == Map.Entry<K, V> 가져오기==========");
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		Iterator<Map.Entry<Integer, String>> iter = set.iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer, String> entry = iter.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		new HashMapExam();

	}

}
