import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1210 {

	static int T = 10;
	static int N;
	static int[][] MAP;
	static boolean[][] visited;
	static int SIZE = 100;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			MAP = new int[SIZE][SIZE];
			visited = new boolean[SIZE][SIZE];

			for (int j = 0; j < SIZE; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < SIZE; k++) {
					MAP[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.printf("#%d %d\n", N, solve());
		}
	}

	public static boolean isIn(int r, int c) {
		if (r >= 0 && r < SIZE && c >= 0 && c < SIZE)
			return true;
		else
			return false;
	}

	public static int solve() {
		int r = SIZE - 1;
		int c = 0;
		int dir = 0;

		for (int i = 0; i < SIZE; i++) {
			if (MAP[r][i] == 2)
				c = i;
		}

		while (r != 0) {
			int left = c + dc[2];
			int right = c + dc[3];

			if (isIn(r, left) && MAP[r][left] == 1 && !visited[r][left]) {
				dir = 2;
				r = r + dr[dir];
				c = c + dc[dir];
				visited[r][c] = true;
			} else if (isIn(r, right) && MAP[r][right] == 1 && !visited[r][right]) {
				dir = 3;
				r = r + dr[dir];
				c = c + dc[dir];
				visited[r][c] = true;
			} else {
				dir = 0;
				r = r + dr[dir];
				c = c + dc[dir];
				visited[r][c] = true;
			}
		}

		return c;
	}

}
