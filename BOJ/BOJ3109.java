package algo0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109 {

	static int R, C;
	static int[][] MAP;
	static int[] dr = { -1, 0, 1 };
	static int[] dc = { 1, 1, 1 };
	static boolean[][] visited;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		MAP = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			char[] arr = br.readLine().toCharArray();

			for (int j = 0; j < C; j++) {
				if (arr[j] == '.')
					MAP[i][j] = 0;
				else
					MAP[i][j] = 1;
			}
		}

		for (int i = 0; i < R; i++) {
			Recursive(i, 0);
		}

		System.out.println(max);
	}

	static boolean Recursive(int r, int c) {
		if (c == C - 1) {
			max++;
			return true;
		} else {
			for (int i = 0; i < 3; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (isIn(nr, nc) && !visited[nr][nc] && MAP[nr][nc] == 0) {
					visited[nr][nc] = true;
					if (Recursive(nr, nc))
						return true;
				}
			}
		}
		return false;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
