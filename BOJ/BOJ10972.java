import java.util.Scanner;

public class BOJ10972 {

	static int N;
	static int[] input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		if (next_permutation()) {
			for (int i = 0; i < N; i++) {
				System.out.print(input[i] + " ");
			}
		} else {
			System.out.println("-1");
		}

	}

	static boolean next_permutation() {
		int i = N - 1;

		while (i > 0 && input[i - 1] >= input[i])
			i--;

		if (i == 0) {
			return false;
		} else {
			int j = N - 1;
			while (input[i - 1] >= input[j])
				j--;

			swap(i - 1, j);

			int k = N - 1;

			while (i < k) {
				swap(i++, k--);
			}

			return true;
		}
	}

	static void swap(int a, int b) {
		int temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
}
