package algo0215;

import java.util.Scanner;

public class BOJ2961 {

	static int N;
	static int[][] ing;
	static int[] output;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ing = new int[N][2];

		for (int i = 0; i < N; i++) {
			ing[i][0] = sc.nextInt();
			ing[i][1] = sc.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			output = new int[i];
			nCr(0, 0, i);
		}

		System.out.println(min);
	}

	static void nCr(int start, int cnt, int R) {
		if (cnt == R) {
			count(R);
			return;
		} else {
			for (int i = start; i < N; i++) {
				output[cnt] = i;
				nCr(i + 1, cnt + 1, R);
			}
		}
	}

	static void count(int R) {
		int S = 1, B = 0;
		for (int i = 0; i < R; i++) {
			S *= ing[output[i]][0];
			B += ing[output[i]][1];
		}

		min = Math.min(min, Math.abs(S - B));
	}

}
