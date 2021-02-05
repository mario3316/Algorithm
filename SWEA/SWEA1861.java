import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1861 {
	static int T;
	static int N;
	static int[][] MAP;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int dist = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int max = 0;
			int roomNum = 0;
			N = Integer.parseInt(br.readLine());
			MAP = new int[N][N];
			visited = new boolean[N][N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					MAP[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					dist = 0;
					for (int l = 0; l < N; l++)
						Arrays.fill(visited[l], false);
					// 거리, visited 초기화

					DFS(1, j, k);

					if (max < dist) {
						max = dist;
						roomNum = MAP[j][k];
					} else if (max != 0 && max == dist) {
						roomNum = Math.min(roomNum, MAP[j][k]);
					}
				}
			}

			System.out.printf("#%d %d %d\n", i, roomNum, max);

		}
	}

	public static void DFS(int cnt, int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (isIn(nr, nc) && !visited[nr][nc]
					&& MAP[nr][nc] == MAP[r][c] + 1) {
				visited[nr][nc] = true;
				DFS(cnt + 1, nr, nc);
			}
		}
		dist = Math.max(cnt, dist);
	}

	public static boolean isIn(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N)
			return true;
		else
			return false;
	}

}
