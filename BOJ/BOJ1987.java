package algo0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {

	static int R, C;
	static String[][] MAP;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		MAP = new String[R][C];

		for (int i = 0; i < R; i++) {
			MAP[i] = br.readLine().split("");
		}

		Recursive(0, 0, MAP[0][0], 1);
		System.out.println(max);
	}

	static void Recursive(int r, int c, String history, int cnt) {

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (isIn(nr, nc) && !history.contains(MAP[nr][nc])) {
				Recursive(nr, nc, history + MAP[nr][nc], cnt + 1);
			}
		}

		max = Math.max(max, cnt);
		return;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
