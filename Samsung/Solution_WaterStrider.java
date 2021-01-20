import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_WaterStrider {

	static int T;
	static int N;
	static int S;
	static int[] dr = { 0, 1, 0 };
	static int[] dc = { 0, 0, 1 };
	static int[][] map;
	static int[][] strider;

	public static boolean isIn(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N)
			return true;
		else
			return false;
	}

	public static int solve() {
		int ans = 0;

		for (int i = 0; i < S; i++) {
			int dir = strider[i][2];

			for (int j = 3; j > 0; j--) {
				int r = strider[i][0];
				int c = strider[i][1];
				int nr = r + dr[dir] * j;
				int nc = c + dc[dir] * j;

				if (!isIn(nr, nc)) // 소금쟁이가 밖으로 나가면
					break;
				else if (map[nr][nc] != -1) { // 다른 소금쟁이가 있을때
					ans = i + 1;
					break;
				} else {
					map[nr][nc] = i;
					strider[i][0] = nr;
					strider[i][1] = nc;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			strider = new int[S][3];

			for (int[] row : map) {
				Arrays.fill(row, -1);
			}

			for (int i = 0; i < S; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					strider[i][j] = Integer.parseInt(st.nextToken());
				}
				map[strider[i][0]][strider[i][1]] = i;
			}

			System.out.printf("#%d %d\n", t, solve());
		}
	}

}
