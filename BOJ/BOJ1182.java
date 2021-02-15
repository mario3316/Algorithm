import java.util.Scanner;

public class BOJ1182 {

	static int N, S;
	static int[] input;
	static boolean[] isSelected;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		subset(0);

		System.out.println(answer);
	}

	static void subset(int cnt) {
		if (cnt == N) {
			int sum = 0;
			boolean flag = true;

			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sum += input[i];
					flag = false;
				}
			}

			if (flag)
				return;
			else if (sum == S)
				answer++;

			return;
		} else {
			isSelected[cnt] = true;
			subset(cnt + 1);

			isSelected[cnt] = false;
			subset(cnt + 1);
		}
	}

}
