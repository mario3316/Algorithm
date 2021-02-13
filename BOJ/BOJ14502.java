import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14502 {

	static int N, M;
	static int[][] MAP;
	static int[][] temp;
	static boolean[][] visited;
	static int[] wall = new int[3];
	static int safeArea = 0;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MAP = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Comb(0, 0);
		System.out.println(safeArea);

	}

	static void Comb(int start, int cnt) {
		if (cnt == 3) {
			temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				temp[i] = MAP[i].clone();
			} // 임시 지도 복사

			for (int i = 0; i < 3; i++) {
				int w = wall[i];
				temp[w / M][w % M] = 1;
			} // 벽 세우기

			spread();
			return;
		} else {
			for (int i = start; i < N * M; i++) {
				if (MAP[i / M][i % M] == 0) { // 빈칸이면 벽을 세움
					wall[cnt] = i;
					Comb(i + 1, cnt + 1);
				}
			}
		}
	}

	static void spread() {
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				if (MAP[i][j] == 2) {
					DFS(i, j);
				}
			}

		safeArea = Math.max(safeArea, countArea());
	}

	static void DFS(int r, int c) {
		visited[r][c] = true;
		temp[r][c] = 2;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (isIn(nr, nc) && !visited[nr][nc] && temp[nr][nc] == 0)
				DFS(nr, nc);
		}
	}

	static boolean isIn(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M)
			return true;
		else
			return false;
	}

	static int countArea() {
		int sum = 0;

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 0)
					sum++;
			}

		return sum;
	}

}
