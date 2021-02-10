import java.util.Scanner;

public class BOJ17406 {

	static class Command {
		int r, c, s;

		Command(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	static int N, M, K;
	static int[][] MAP;
	static int[][] tMAP;
	static Command[] C;
	static int[] perm;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		C = new Command[K];
		perm = new int[K];
		MAP = new int[N][M];
		tMAP = new int[N][M];
		for (int i = 0; i < K; i++)
			perm[i] = i;

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				MAP[i][j] = sc.nextInt();

		for (int i = 0; i < K; i++) {
			C[i] = new Command(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
		}

		do {
			for (int i = 0; i < N; i++) {
				tMAP[i] = MAP[i].clone();
			}

			for (int i = 0; i < K; i++) {
				Command tc = C[perm[i]];
				int len = tc.s * 2 + 1;
				int rotateCnt = len / 2;
				int r = tc.r - tc.s;
				int c = tc.c - tc.s;

				while (rotateCnt > 0) {
					rotate(r, c, len);
					r++;
					c++;
					len -= 2;
					rotateCnt--;
				}
			}

			int arrMin = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++)
					sum += tMAP[i][j];
				arrMin = Math.min(arrMin, sum);
			}

			min = Math.min(min, arrMin);

		} while (next_permutation());

		System.out.println(min);
	}

	static void rotate(int r, int c, int len) {
		int ir = r;
		int ic = c;
		int dir = 0;
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		int temp = tMAP[ir][ic];

		while (!(nr == ir && nc == ic)) {
			nr = r + dr[dir];
			nc = c + dc[dir];

			if (nr >= ir && nr < ir + len && nc >= ic && nc < ic + len) {
				tMAP[r][c] = tMAP[nr][nc];
				r = nr;
				c = nc;
			} else {
				dir = (dir + 1) % 4;
			}
		}
		tMAP[ir][ic + 1] = temp;
	}

	static boolean next_permutation() {
		int i = K - 1;

		while (i > 0 && perm[i - 1] >= perm[i])
			i--;

		if (i == 0) {
			return false;
		} else {
			int j = K - 1;
			while (perm[i - 1] >= perm[j])
				j--;

			swap(i - 1, j);

			int k = K - 1;

			while (i < k) {
				swap(i, k);
				i++;
				k--;
			}

			return true;
		}
	}

	static void swap(int a, int b) {
		int temp = perm[a];
		perm[a] = perm[b];
		perm[b] = temp;
	}

}
