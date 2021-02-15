package algo0215;

import java.util.Scanner;

public class SWEA6808 {
	static int T;
	static int[] cards = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
	static int[] input;
	static int[] output;
	static boolean[] visited;
	static int win = 0;
	static int lose = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			win = 0;
			lose = 0;
			visited = new boolean[18];
			input = new int[9];
			output = new int[9];
			for (int i = 0; i < 9; i++) {
				input[i] = sc.nextInt();
				visited[input[i] - 1] = true;
			}

			perm(0);
			System.out.printf("#%d %d %d\n", t, win, lose);
		}
	}

	static void perm(int cnt) {
		if (cnt == 9) {
			score();
			return;
		} else {
			for (int i = 0; i < 18; i++) {
				if (!visited[i]) {
					visited[i] = true;
					output[cnt] = cards[i];
					perm(cnt + 1);
					visited[i] = false;
				}
			}
		}
	}

	static void score() {
		int me = 0, you = 0;

		for (int i = 0; i < 9; i++) {
			if (input[i] > output[i]) {
				me += input[i] + output[i];
			} else {
				you += input[i] + output[i];
			}
		}

		if (me > you)
			win++;
		else if (me < you)
			lose++;

	}

}
