import java.util.Scanner;

public class BOJ10973 {
	static int N;
	static int[] input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		if (prev_permutation()) {
			for (int i = 0; i < N; i++)
				System.out.print(input[i] + " ");
		} else {
			System.out.println("-1");
		}
		sc.close();
	}

	static boolean prev_permutation() {
		int i = input.length - 1;

		while (i > 0 && input[i - 1] <= input[i])
			i--;

		if (i == 0) {
			return false;
		} else {
			int j = i - 1;
			while (j + 1 < input.length && input[i - 1] >= input[j + 1])
				j++;

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
