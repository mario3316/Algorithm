import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Robot {

	static int T;
	static int N;
	static char[][] map;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 }; // 우 좌 상 하

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}

			System.out.printf("#%d %d\n", t, solve());
		}
	}

	public static boolean isIn(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N)
			return true;
		else
			return false;
	}

	public static int solve() {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char robot = map[i][j];
				if (robot == 'A') {
					int r = i;
					int c = j;

					while (isIn(r + dr[0], c + dc[0]) && map[r + dr[0]][c + dc[0]] == 'S') {
						r += dr[0];
						c += dc[0];
						cnt++;
					}
				} else if (robot == 'B') {
					int r = i;
					int c = j;

					for (int d = 0; d < 2; d++) {
						while (isIn(r + dr[d], c + dc[d]) && map[r + dr[d]][c + dc[d]] == 'S') {
							r += dr[d];
							c += dc[d];
							cnt++;
						}

						r = i;
						c = j;
					}

				} else if (robot == 'C') {
					int r = i;
					int c = j;

					for (int d = 0; d < 4; d++) {
						while (isIn(r + dr[d], c + dc[d]) && map[r + dr[d]][c + dc[d]] == 'S') {
							r += dr[d];
							c += dc[d];
							cnt++;
						}

						r = i;
						c = j;
					}

				}
			}
		}

		return cnt;
	}
}
