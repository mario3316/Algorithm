package algo0208;

import java.util.Scanner;

public class SWEA9229 {

	static int T, N, M;
	static int[] weight;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			max = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			weight = new int[N];

			for (int i = 0; i < N; i++) {
				weight[i] = sc.nextInt();
			}

			Comb(0, 0, 0);

			if (max == 0)
				System.out.printf("#%d -1\n", t);
			else
				System.out.printf("#%d %d\n", t, max);
		}
	}

	static void Comb(int cnt, int start, int sum) {
		if (cnt == 2) {
			if (sum <= M) {
				max = Math.max(max, sum);
			}
			return;
		} else {
			for (int i = start; i < N; i++) {
				Comb(cnt + 1, i + 1, sum + weight[i]);
			}
		}
	}

}
