import java.util.Scanner;

//선형검색(보초법)
public class p105_33 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("요솟수: ");
		int num = sc.nextInt();

		int[] arr = new int[num + 1]; // 검색값 저장 위해 +1

		for (int i = 0; i < arr.length-1; i++) {
			System.out.print("arr[" + i + "]:");
			arr[i] = sc.nextInt();
		}

		System.out.print("검색할 값: ");
		int findNum = sc.nextInt();

		int idx = search(num, arr, findNum);

		if (idx == -1) {
			System.out.println("검색하고자 하는 값을 찾을 수 없습니다.");
		} else {
			System.out.println("검색하고자 하는 값은 arr[" + idx + "]에 있습니다.");
		}
	}

	static int search(int num, int[] arr, int findNum) {

		arr[num] = findNum; // 검색값 저장

		int i = 0;
		while (true) {
			if (arr[i] == findNum)
				break;
			i++;
		}

		return i == num ? -1 : i;
	}
}
