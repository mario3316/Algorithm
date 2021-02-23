import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17135 {

	static int N, M, D;
	static int[][] MAP;
	static int[] output;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		MAP = new int[N + 1][M]; // N번째줄은 성
		output = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Comb(0, 0);
		System.out.println(max);
	}

	static void Comb(int start, int cnt) {
		if (cnt == 3) {
			max = Math.max(max, game());
			return;
		} else {
			for (int i = start; i < M; i++) {
				output[cnt] = i;
				Comb(i + 1, cnt + 1);
			}
		}
	}

	static int game() {
		int count = 0;

		int[][] tmap = new int[N + 1][M];
		for (int i = 0; i < N; i++)
			tmap[i] = MAP[i].clone();

		int archerRow = N;

		while (archerRow != 0) {
			ArrayList<Point> list = new ArrayList<>();

			for (int i = 0; i < 3; i++) {
				Point e = BFS(tmap, new Point(archerRow, output[i]));

				if (e.x == -1 && e.y == -1) {
					continue;
				} else {
					list.add(e);
				}
			}

			for (Point p : list) {
				if (tmap[p.x][p.y] == 1) {
					tmap[p.x][p.y] = 0;
					count++;
				}
			}

			archerRow--;
		}
		return count;
	}

	static Point BFS(int[][] tmap, Point p) {
		boolean[][] visited = new boolean[N + 1][M];
		Queue<Point> Q = new LinkedList<>();
		Q.offer(p);
		visited[p.x][p.y] = true;

		int minDist = Integer.MAX_VALUE;
		Point minP = new Point(-1, -1);

		while (!Q.isEmpty()) {
			Point current = Q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = current.x + dr[i];
				int nc = current.y + dc[i];

				if (isIn(nr, nc, p.x) && !visited[nr][nc]) {

					if (tmap[nr][nc] == 1) {
						int tempDist = Math.abs(nr - p.x) + Math.abs(nc - p.y);

						if (tempDist <= D) {
							if (tempDist == minDist) {
								if (nc < minP.y)
									minP = new Point(nr, nc);
							} else if (tempDist < minDist) {
								minDist = tempDist;
								minP = new Point(nr, nc);
							}
						}
					}
					Q.offer(new Point(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}

		return minP;
	}

	static boolean isIn(int r, int c, int level) {
		return r >= 0 && r < level && c >= 0 && c < M;
	}

}
