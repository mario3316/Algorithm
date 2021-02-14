import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963 {

	static int W, H;
	static int[][] MAP;
	static boolean[][] visited;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 }; // 8방
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if (H == 0 && W == 0)
				break;

			MAP = new int[H][W];
			visited = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					MAP[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 지도 입력

			cnt = 0;

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					// 지도에서 Land 인것만 방문하지 않았으면 DFS 시작
					if (!visited[i][j] && MAP[i][j] == 1) {
						DFS(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}

	static void DFS(int r, int c) {
		visited[r][c] = true;

		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 상하좌우 대각선이 땅이면 방문
			if (isIn(nr, nc) && !visited[nr][nc] && MAP[nr][nc] == 1) {
				DFS(nr, nc);
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}

}
