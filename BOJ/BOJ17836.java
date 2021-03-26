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

//		<����> 
//		1. ���� ���� ���� �ִܰŸ��� ����
//		2.1. 1�� BFS�� ������ �߿� ���� ������ ��~���� �Ÿ��� ���� (���� ������ �����Ƿ� �� ���� ���ֱ����� �Ÿ��� ��Ŭ����� �Ÿ�)
//		2.2. �˺��� ���ְ� ���� ������ ���ʿ� �� �Ÿ��� �ִܰŸ��̹Ƿ� �ٷ� 3������ �Ѿ
//		3. 1�� �Ÿ��� 2�� �Ÿ��� �ּҰ��� ���ϰ� �� ���� ���ѽð� T�������� �Ǻ�

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
			} // ���ָ� ã���� ����
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

		if (fromSword != 0) { // ���� ã���� ��
			if (dist[N - 1][M - 1] != 0) {
				answer = Math.min(fromSword, dist[N - 1][M - 1]);
			} else {
				answer = fromSword;
			}
		} else { // ���� ��ã���� ��
			answer = dist[N - 1][M - 1];
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
