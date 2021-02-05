import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_WaterStrider2 {

	static int T;
	static int N;
	static int S;
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };
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
			if (strider[i][3] == 0) { // 살아있는 소금쟁이만 실행
				int dir = strider[i][2];

				for (int j = 3; j > 0; j--) {
					int r = strider[i][0];
					int c = strider[i][1];
					int nr = r + dr[dir] * j;
					int nc = c + dc[dir] * j;

					if (!isIn(nr, nc)) { // 소금쟁이가 밖으로 나가면
						strider[i][3] = -1; // 사망
						break;
					} else if (map[nr][nc] != -1) { // 다른 소금쟁이가 있을때
						strider[i][3] = -1; // 사망
						break;
					} else {
						strider[i][0] = nr;
						strider[i][1] = nc;
						if (j == 1) { // 세번째 뛰는 순서이면
							if (map[nr][nc] != -1) { // 만약 그자리에 소금쟁이가 있으면 죽임
								strider[map[nr][nc]][3] = -1;
							}
							map[nr][nc] = i;
						}
					}
				}
			}
		}

		for (int i = 0; i < S; i++) {
			if (strider[i][3] == 0)
				ans++;
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
			strider = new int[S][4];

			for (int[] row : map) {
				Arrays.fill(row, -1);
			}

			for (int i = 0; i < S; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					strider[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.printf("#%d %d\n", t, solve());
		}
	}

}
