import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2105 {

	static int T, N;
	static int[][] MAP;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };
	static int max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			MAP = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					MAP[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			max = -1;

			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					makeSquare(i, j);

			System.out.printf("#%d %d\n", t, max);
		}

	}

	static void makeSquare(int r, int c) {
		for (int i = N - 1; i > 0; i--) {
			int nr = r + dr[0] * i;
			int nc = c + dc[0] * i;
			if (isIn(nr, nc)) {
				for (int j = N - 1; j > 0; j--) {
					int nr2 = nr + dr[1] * j;
					int nc2 = nc + dc[1] * j;
					if (isIn(nr2, nc2)) {
						int nr3 = nr2 + dr[2] * i;
						int nc3 = nc2 + dc[2] * i;
						if (isIn(nr3, nc3)) {
							moveCafe(r, c, i, j);
						}
					}
				}
			}
		}
	}

	static void moveCafe(int r, int c, int len1, int len2) {
		boolean[] dessert = new boolean[101];
		int sum = 0;

		for (int i = 0; i < 4; i++) {
			int tLen;
			if (i % 2 == 0)
				tLen = len1;
			else
				tLen = len2;

			for (int j = 0; j < tLen; j++) {
				r += dr[i];
				c += dc[i];
				if (dessert[MAP[r][c]])
					return;
				else {
					dessert[MAP[r][c]] = true;
					sum++;
				}
			}
		}

		max = Math.max(max, sum);

	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
