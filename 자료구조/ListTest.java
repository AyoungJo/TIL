import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 값 삽입,조회 시 배열리스트와 연결리스트 실행시간 비교하기
 */
public class ListTest {

	public static void main(String[] args) {

		long start, end; // 시간 측정 시작시간, 끝시간
		long N = 100000;

		ArrayList<Integer> arrList = new ArrayList<>();
		LinkedList<Integer> linkList = new LinkedList<>();

		/* add 메서드 */
		// ArrayList(배열리스트)
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			arrList.add(100); // 인덱스 가장 마지막에 추가
		}
		end = System.currentTimeMillis();

		System.out.println("ArrayList 실행 시간 (ms) : " + (end - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			arrList.add(arrList.size() / 2, 100); // add(인덱스,값) -> 값을 인덱스 중간에 삽입
		}
		end = System.currentTimeMillis();

		System.out.println("ArrayList add(인덱스,값) 실행 시간 (ms) : " + (end - start));

		// LinkedList(연결리스트)
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			linkList.add(100);
		}
		end = System.currentTimeMillis();

		System.out.println("LinkedList 실행 시간 (ms) : " + (end - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			linkList.add(linkList.size() / 2, 100); // add(인덱스,값) -> 값을 인덱스 중간에 삽입
		}
		end = System.currentTimeMillis();

		System.out.println("LinkedList add(인덱스,값) 실행 시간 (ms) : " + (end - start));

		/* get 메서드 */
		// ArrayList(배열리스트) - add 메서드를 이용해 값 추가
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			arrList.get(100);
		}
		end = System.currentTimeMillis();

		System.out.println("ArrayList get 실행 시간 (ms) : " + (end - start));

		for (int i = 0; i < N; i++) {
			linkList.get(100);
		}
		end = System.currentTimeMillis();

		System.out.println("linkList get 실행 시간 (ms) : " + (end - start));

		/* 삭제 메서드 */
		// arrList 중간 삭제
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			arrList.remove(arrList.size() - 1);
		}
		end = System.currentTimeMillis();

		System.out.println("ArrayList 끝 삭제 실행 시간 (ms) : " + (end - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			arrList.remove(arrList.size() / 2);
		}
		end = System.currentTimeMillis();

		System.out.println("ArrayList 중간 삭제 실행 시간 (ms) : " + (end - start));

		// arrList.remove(Integer.valueOf(100)); //중간값 삭제

		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			linkList.remove(linkList.size() - 1);
		}
		end = System.currentTimeMillis();

		System.out.println("ArrayList 끝 삭제 실행 시간 (ms) : " + (end - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			linkList.remove(linkList.size() / 2);
		}
		end = System.currentTimeMillis();

		System.out.println("ArrayList 중간 삭제 실행 시간 (ms) : " + (end - start));
	}

}
