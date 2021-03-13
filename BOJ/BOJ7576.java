import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {

	static int N, M;
	static int[][] MAP;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		/*
		 * <로직> 1. 이중 for문 돌면서 익은 토마토들 주위를 익힘 2. 이중 for문 중 안익은 토마토가 없으면 끝
		 */
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		MAP = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		BFS();

		System.out.println("!!!!!");
		if (answer != -1)
			solve();

		System.out.println(answer);
	}

	static boolean validate() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (MAP[i][j] == 0) {
					BFS();
				}
			}
		}

	}

	static boolean BFS() {
		Queue<int[]> Q = new LinkedList<>();
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (MAP[i][j] == 0) {
					Q.offer(new int[] { i, j });
					visited[i][j] = true;

					while (!Q.isEmpty()) {
						int[] current = Q.poll();

						if (MAP[current[0]][current[1]] == 1)
							return true;

						for (int d = 0; d < 4; d++) {
							int nr = current[0] + dr[d];
							int nc = current[1] + dc[d];

							if (isIn(nr, nc) && !visited[nr][nc]
									&& MAP[i][j] != -1) {
								Q.offer(new int[] { nr, nc });
								visited[nr][nc] = true;
							}
						}
					}

					return false;
				}
			}
		}
	}

	static void solve() {
		while (true) {
			boolean flag = false;
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (MAP[i][j] == 1) {
						rot(i, j);
					} else if (MAP[i][j] == 0) {
						flag = true;
					}
				}
			}

			if (!flag) {
				break;
			} else {
				update();
				answer++;
			}
		}
	}

	static void rot(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (isIn(nr, nc) && MAP[nr][nc] == 0) {
				visited[nr][nc] = true;
			}
		}
	}

	static void update() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					MAP[i][j] = 1;
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
