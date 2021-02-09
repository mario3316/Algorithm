import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
	static class Point {
		int r, c, dist = 0;

		Point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	static int N, M;
	static char[][] MAP;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MAP = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			MAP[i] = br.readLine().toCharArray();
		}

		Point start = new Point(0, 0, 1);
		System.out.println(BFS(start));

	}

	static int BFS(Point p) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(p);
		visited[p.r][p.c] = true;

		while (!Q.isEmpty()) {
			Point current = Q.poll();
			if (current.r == N - 1 && current.c == M - 1) {
				return current.dist;
			}

			for (int i = 0; i < 4; i++) {
				int nr = current.r + dr[i];
				int nc = current.c + dc[i];

				if (isIn(nr, nc) && !visited[nr][nc] && MAP[nr][nc] == '1') {
					Q.offer(new Point(nr, nc, current.dist + 1));
					visited[nr][nc] = true;
				}
			}
		}

		return 0;
	}

	static boolean isIn(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M)
			return true;
		else
			return false;
	}

}
