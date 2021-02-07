import java.util.Arrays;
import java.util.Scanner;

public class BOJ10819 {

	static int N;
	static int[] input;
	static int max = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];

		for (int i = 0; i < N; i++)
			input[i] = sc.nextInt();

		Arrays.sort(input);

		do {
			max = Math.max(max, calc());
		} while (next_permutation());

		System.out.println(max);
	}

	static int calc() {
		int res = 0;
		for (int i = 0; i < N - 1; i++) {
			res += Math.abs(input[i] - input[i + 1]);
		}
		return res;
	}

	static boolean next_permutation() {
		int i = N - 1;
		int j = N - 1;
		int k = N - 1;

		while (i > 0 && input[i - 1] >= input[i])
			i--;

		if (i == 0)
			return false;
		else {
			while (input[i - 1] >= input[j])
				j--;

			swap(i - 1, j);

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
