import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2933 {

	static int R, C, N;
	static int[] Throws;
	static char[][] MAP;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		MAP = new char[R][C];

		for (int i = 0; i < R; i++) {
			MAP[i] = br.readLine().toCharArray();
		}

		N = Integer.parseInt(br.readLine());
		Throws = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Throws[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			throwStick(i);
		}

		for (int j = 0; j < R; j++) {
			System.out.println(new String(MAP[j]));
		}

	}

	static void throwStick(int idx) {
		int level = R - Throws[idx];
		if (idx % 2 == 0) { // ���ʺ���
			for (int i = 0; i < C; i++) {
				if (MAP[level][i] == 'x') {
					MAP[level][i] = '.';

					// ���� Ŭ�����Ͱ� ���߿� ���ִ��� �˻�
					for (int d = 0; d < 4; d++) {
						if (isIn(level + dr[d], i + dc[d])
								&& MAP[level + dr[d]][i + dc[d]] == 'x') {
							if (!check(level + dr[d], i + dc[d])) {
								// ���߿� ���ִٸ� Ŭ�����͸� ����
								dropCluster();
							}
						}
					}

					break;
				}
			}
		} else {
			for (int i = C - 1; i >= 0; i--) {
				if (MAP[level][i] == 'x') {
					MAP[level][i] = '.';

					// ���� Ŭ�����Ͱ� ���߿� ���ִ��� �˻�
					for (int d = 0; d < 4; d++) {
						if (isIn(level + dr[d], i + dc[d])
								&& MAP[level + dr[d]][i + dc[d]] == 'x') {
							if (!check(level + dr[d], i + dc[d])) {
								// ���߿� ���ִٸ� Ŭ�����͸� ����
								dropCluster();
							}
						}
					}

					break;
				}
			}
		}
	}

	static void dropCluster() {
		// visited = true �ΰ͵��� Ŭ������

		int min = Integer.MAX_VALUE;

		for (int c = 0; c < C; c++) {
			for (int r = R - 1; r >= 0; r--) {
				if (visited[r][c]) {
					int level = r, cnt = 0;
					while (level + 1 < R && MAP[level + 1][c] != 'x') {
						level++;
						cnt++;
					}

					min = Math.min(min, cnt);
					break;
				}
			}
		}
		// �ִ�� ������ �ִ� ���� ���
		// ���� �� �ִ� ���� �� ���� ���� ���� ���� ��ġ�� ����

		for (int r = R - 1; r >= 0; r--) {
			for (int c = 0; c < C; c++) {
				if (visited[r][c]) {
					MAP[r + min][c] = 'x';
					MAP[r][c] = '.';
				}
			}
		}
		// �ǾƷ����� min ��ŭ ������
	}

	static boolean check(int r, int c) {
		boolean flag = false;
		visited = new boolean[R][C];
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(r, c));
		visited[r][c] = true;

		while (!Q.isEmpty()) {
			Point current = Q.poll();
			if (current.x == R - 1) { // �ٴ��̸� �������ʾƵ� �ǹǷ� true�� return �ϰ� ����
				flag = true;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = current.x + dr[i];
				int nc = current.y + dc[i];

				if (isIn(nr, nc) && !visited[nr][nc] && MAP[nr][nc] == 'x') {
					Q.offer(new Point(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}

		return flag;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
