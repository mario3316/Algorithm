package algo0218;

import java.util.Scanner;

public class SWEA1265 {

	static int T;
	static int N, P;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			P = sc.nextInt();

			int div = N / P;
			int rem = N % P;
			long ans = 1;
			for (int i = 0; i < P; i++) {
				if (rem != 0) {
					ans *= div + 1;
					rem--;
				} else
					ans *= div;
			}

			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
