import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1249 {

	static int T, N;
	static int[][] MAP;
	static int[][] dist;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			MAP = new int[N][N];
			dist = new int[N][N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}

			for (int i = 0; i < N; i++) {
				String[] temp = sc.next().split("");

				for (int j = 0; j < N; j++) {
					MAP[i][j] = Integer.parseInt(temp[j]);
				}
			}

			BFS();

			System.out.printf("#%d %d\n", t, dist[N - 1][N - 1]);
		}
	}

	static void BFS() {
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] { 0, 0 });
		dist[0][0] = 0;

		while (!Q.isEmpty()) {
			int[] current = Q.poll();
			int r = current[0];
			int c = current[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (isIn(nr, nc) && dist[nr][nc] > dist[r][c] + MAP[nr][nc]) {
					Q.add(new int[] { nr, nc });
					dist[nr][nc] = dist[r][c] + MAP[nr][nc];
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
