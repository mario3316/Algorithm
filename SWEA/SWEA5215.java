package algo0208;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA5215 {

	static int T, N, L;
	static boolean[] selected;
	static int[][] info; // 점수 , 칼로리
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			max = 0;
			N = sc.nextInt();
			L = sc.nextInt();
			info = new int[N][2];
			selected = new boolean[N];

			for (int i = 0; i < N; i++) {
				info[i][0] = sc.nextInt();
				info[i][1] = sc.nextInt();
			}

			Subset(0, 0, 0);
			System.out.printf("#%d %d\n", t, max);
		}
	}

	static void Subset(int cnt, int score, int cal) {
		if (cnt == N) {

			if (cal <= L) {
				Arrays.toString(selected);
				max = Math.max(max, score);
			}
			return;
		} else {
			selected[cnt] = true;
			Subset(cnt + 1, score + info[cnt][0], cal + info[cnt][1]);

			selected[cnt] = false;
			Subset(cnt + 1, score, cal);
		}
	}

}
