import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {

	static int N, M;
	static int[][] MAP;
	static int[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<int[]> Q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		MAP = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				if (MAP[i][j] == 1)
					Q.offer(new int[] { i, j });
			}
		}

		BFS();
		if (!checkMap()) {
			System.out.println("-1");
		} else {
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					answer = Math.max(answer, visited[i][j]);
				}
			}

			System.out.println(answer);
		}
	}

	static void BFS() {
		while (!Q.isEmpty()) {
			int[] current = Q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];

				if (isIn(nr, nc) && visited[nr][nc] == 0 && MAP[nr][nc] == 0) {
					Q.offer(new int[] { nr, nc });
					visited[nr][nc] = visited[current[0]][current[1]] + 1;
				}
			}
		}
	}

	static boolean checkMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (MAP[i][j] == 0 && visited[i][j] == 0)
					return false;
			}
		}

		return true;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
