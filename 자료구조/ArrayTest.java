import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {

		int[] arr = new int[6];

		System.out.println(arr);
		System.out.println(Arrays.toString(arr));

		// Arrays.fill(배열, 값); >> 해당 배열을 특정값으로 채움
		Arrays.fill(arr, 100); // 배열변수명, 적용할 값
		System.out.println(Arrays.toString(arr));

		arr = new int[] { 5, 2, 4, 3, 1 };
		System.out.println(Arrays.toString(arr));

		// Arrays.sort(배열) >> 값 오름차순 정렬
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		// Arrays.copyOfRange(배열명, i, j) // 배열의 i부터 j-1값 까지 가져오기
		int[] copyArr = Arrays.copyOfRange(arr, 1, 4);
		System.out.println(Arrays.toString(copyArr));

		int[][] arr2d = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		System.out.println(arr2d);

		System.out.println(arr2d[0]);
		System.out.println(Arrays.toString(arr2d[0]));

		for (int i = 0; i < arr2d.length; i++) {
//			System.out.println(arr2d[i]);
			System.out.println(Arrays.toString(arr2d[i]));
		}
		System.out.println(Arrays.deepToString(arr2d));

	}

}
