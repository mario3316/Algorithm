import java.util.Arrays;
import java.util.Scanner;

public class BOJ2138 {

	static int N;
	static char[] arr, start, target;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		start = sc.next().toCharArray();
		target = sc.next().toCharArray();

		arr = start.clone();
		int answer1 = solve();

		arr = start.clone();
		press(0);
		int answer2 = solve();

		if (answer1 != -1 && answer2 != -1)
			System.out.println(Math.min(answer1, answer2 + 1));
		else if (answer1 == -1 && answer2 != -1)
			System.out.println(answer2 + 1);
		else if (answer2 == -1 && answer1 != -1)
			System.out.println(answer1);
		else
			System.out.println("-1");

	}

	static int solve() {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			if (arr[i] != target[i]) {
				if (i + 1 < N) {
					press(i + 1);
					cnt++;
				}
			}
		}

		if (Arrays.equals(arr, target))
			return cnt;
		else
			return -1;

	}

	static void press(int n) {
		if (n - 1 >= 0)
			Switch(n - 1);
		if (n >= 0 && n < N)
			Switch(n);
		if (n + 1 < N)
			Switch(n + 1);
	}

	static void Switch(int n) {
		if (arr[n] == '0')
			arr[n] = '1';
		else
			arr[n] = '0';
	}

}
