package ex0327.set;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class LottoTest extends TreeSet<Integer> {
	public LottoTest() {

		// 1~45 사이의 난수를 발생시켜 Set에 숫자 6개를 저장한다.
		Random r = new Random();
		while (super.size() < 6) {
			int no = r.nextInt(45) + 1;// 0~44 숫자 발생 , 1부터 시작 +1
			// super.add((int) ((Math.random() * 46) + 1));
			super.add(no);
		}

		// 출력
		// super는 단독으로 사용 불가
		System.out.println("저장된 번호(오름차순) : " + this);

		System.out.println("저장된 번호(내림차순) : ");
		Iterator<Integer> it = this.descendingIterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
	}

	public static void main(String[] args) {
		new LottoTest();
	}
}
