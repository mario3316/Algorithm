import java.util.Scanner;

public class BOJ10974 {
	static int N;
	static int[] input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}

		do {
			for (int i = 0; i < N; i++)
				System.out.print(input[i] + " ");
			System.out.println();
		} while (next_permutation());
	}

	static boolean next_permutation() {
		int i = input.length - 1;

		while (i > 0 && input[i - 1] >= input[i])
			i--;

		if (i == 0) {
			return false;
		} else {
			int j = input.length - 1;

			while (input[i - 1] >= input[j])
				j--;

			swap(i - 1, j);

			int k = input.length - 1;

			while (i < k) {
				swap(i, k);
				i++;
				k--;
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
