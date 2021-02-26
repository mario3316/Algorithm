import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {

	static int N, L, R;
	static int[][] MAP;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		MAP = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void BFS(int r, int c) {
		int sum = 0, cnt = 0;
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(r, c));
		visited[r][c] = true;
		sum += MAP[r][c];
		cnt++;

		while (!Q.isEmpty()) {
			Point current = Q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = current.x + dr[i];
				int nc = current.y + dc[i];

				if (isIn(nr, nc) && !visited[nr][nc]
						&& isOpen(current.x, current.y, nr, nc)) {
					Q.offer(new Point(nr, nc));
					visited[nr][nc] = true;
					sum += MAP[nr][nc];
					cnt++;
				}
			}
		}

		if (cnt > 1) {
			answer++;
			int avg = sum / cnt;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j])
						MAP[i][j] = avg;
				}
			}
		}
	}

	static boolean isOpen(int r, int c, int nr, int nc) {
		int diff = Math.abs(MAP[r][c] - MAP[nr][nc]);
		if (diff >= L && diff <= R)
			return true;
		else
			return false;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
