import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17836 {

	static int N, M, T;
	static int[][] MAP;
	static int[][] dist;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {

//		<로직> 
//		1. 공주 까지 가는 최단거리를 구함
//		2.1. 1번 BFS를 돌리는 중에 검이 나오면 검~공주 거리를 구함 (벽을 뚫을수 있으므로 검 부터 공주까지의 거리는 유클리디안 거리)
//		2.2. 검보다 공주가 먼저 나오면 애초에 그 거리가 최단거리이므로 바로 3번으로 넘어감
//		3. 1번 거리와 2번 거리중 최소값을 구하고 그 값이 제한시간 T이하인지 판별

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		MAP = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		BFS();

		if (answer == 0 || answer > T) {
			System.out.println("Fail");
		} else {
			System.out.println(answer);
		}
	}

	static void BFS() {
		int fromSword = 0;
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] { 0, 0 });
		visited[0][0] = true;
		dist[0][0] = 0;

		while (!Q.isEmpty()) {
			int[] current = Q.poll();
			int cr = current[0];
			int cc = current[1];

			if (cr == N - 1 && cc == M - 1) {
				break;
			} // 공주를 찾으면 종료
			if (fromSword == 0 && MAP[cr][cc] == 2) {
				fromSword = dist[cr][cc]
						+ Math.abs((N - 1 - cr) + (M - 1 - cc));
			}

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (isIn(nr, nc) && !visited[nr][nc] && MAP[nr][nc] != 1) {
					Q.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
					dist[nr][nc] = dist[cr][cc] + 1;
				}
			}
		}

		if (fromSword != 0) { // 검을 찾았을 때
			if (dist[N - 1][M - 1] != 0) {
				answer = Math.min(fromSword, dist[N - 1][M - 1]);
			} else {
				answer = fromSword;
			}
		} else { // 검을 못찾았을 때
			answer = dist[N - 1][M - 1];
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
