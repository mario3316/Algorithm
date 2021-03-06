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
//			System.out.println("===========");
//			for (int j = 0; j < R; j++) {
//				System.out.println(new String(MAP[j]));
//			}
//			System.out.println("===========");
		}

	}

	static void throwStick(int idx) {
		int level = R - Throws[idx];
		if (idx % 2 == 0) { // ���ʺ���
			for (int i = 0; i < C; i++) {
				if (MAP[level][i] == 'x') {
					MAP[level][i] = '.';

					// ���ʿ��� �μ����� ���� �پ��ִ� Ŭ������, ������ �پ� �ִ� Ŭ�����Ͱ� ���߿� ���ִ��� �˻�
					for (int j = 0; j <= 3; j += 3) { // ��: 0, �� : 3
						if (isIn(level + dr[j], i + dc[j])
								&& MAP[level + dr[j]][i + dc[j]] == 'x') {
							if (!check(level + dr[j], i + dc[j])) {
								// ���߿� ���ִٸ� Ŭ�����͸� ����

								System.out.println("===========");
								for (int d = 0; d < R; d++) {
									System.out.println(new String(MAP[d]));
								}
								System.out.println("===========");

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

					// �����ʿ��� �μ����� ���� �پ��ִ� Ŭ������, ���ʿ� �پ� �ִ� Ŭ�����Ͱ� ���߿� ���ִ��� �˻�
					for (int j = 0; j <= 2; j += 2) { // ��: 0, �� : 2
						if (isIn(level + dr[j], i + dc[j])
								&& MAP[level + dr[j]][i + dc[j]] == 'x') {
							if (!check(level + dr[j], i + dc[j])) {
								System.out.println("===========");
								for (int d = 0; d < R; d++) {
									System.out.println(new String(MAP[d]));
								}
								System.out.println("===========");
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

		int min = 0;

		for (int c = 0; c < C; c++) {
			for (int r = R - 1; r >= 0; r--) {
				if (visited[r][c]) {
					int level = r, cnt = 0;
					while (level < R && MAP[level][c] != 'x') {
						level++;
						cnt++;
					}
					System.out.println(r + " / " + c + " / " + cnt);

					min = Math.min(min, cnt);
					break;
				}
			}
		}
		// �ִ�� ������ �ִ� ���� ���
		// ���� �� �ִ� ���� �� ���� ���� ���� ���� ��ġ�� ����

		System.out.println(min);
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

		System.out.println("=====");
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visited[i][j])
					System.out.print("1");
				else
					System.out.print("0");
			}
			System.out.println();
		}
		System.out.println("=====");

		return flag;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
