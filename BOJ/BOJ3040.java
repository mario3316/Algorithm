import java.util.Scanner;

public class BOJ3040 {

	static int N = 9;
	static int R = 7;
	static int[] input = new int[N];
	static int[] output = new int[R];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < N; i++)
			input[i] = sc.nextInt();

		Comb(0, 0);
	}

	static void Comb(int start, int cnt) {
		if (cnt == R) {
			int sum = 0;
			for (int i = 0; i < R; i++) {
				sum += output[i];
			}

			if (sum == 100) {
				for (int i = 0; i < R; i++)
					System.out.println(output[i]);
			}

			return;
		} else {
			for (int i = start; i < N; i++) {
				output[cnt] = input[i];
				Comb(i + 1, cnt + 1);
			}
		}
	}
}
