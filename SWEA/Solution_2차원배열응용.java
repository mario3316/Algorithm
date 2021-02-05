import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2차원배열응용 {

	static int T;
	static int N;
	static char[][] map;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int max = -1;
			N = Integer.parseInt(br.readLine());
			map = new char[N + 2][N + 2];

			for (int i = 0; i < map.length; i++) {
				Arrays.fill(map[i], 'B');
			}

			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 1; j < N + 1; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					max = Math.max(max, go(i, j));
				}
			}

			System.out.printf("#%d %d\n", t, max);
		}

	}

	public static int go(int r, int c) {
		int cnt = 0;
		boolean flag = true;

		for (int i = 0; i < 8; i++) {
			if (map[r + dr[i]][c + dc[i]] == 'G') {
				flag = false;
				break;
			}
		}

		if (flag) {
			for (int i = 1; i < N + 1; i++) {
				if (map[i][c] == 'B') {
					cnt++;
				}
				if (map[r][i] == 'B') {
					cnt++;
				}
			}
		} else {
			cnt = 2;
		}

		return cnt - 1;
	}

}
