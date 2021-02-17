import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ18405 {

	static class Virus implements Comparable<Virus> {
		int r, c, num, sec;

		Virus(int r, int c, int num, int sec) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.sec = sec;
		}

		public int compareTo(Virus o) {
			if (this.sec == o.sec) {
				return this.num - o.num;
			} else
				return this.sec - o.sec;
		}
	}

	static int N, K;
	static int[][] MAP;
	static int S, X, Y;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static PriorityQueue<Virus> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		MAP = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				if (MAP[i][j] != 0) {
					pq.add(new Virus(i, j, MAP[i][j], 0));
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		for (int i = 0; i < S; i++) {
			bfs();
		}
		System.out.println(MAP[X - 1][Y - 1]);
	}

	static void bfs() {
		while (!pq.isEmpty()) {
			Virus current = pq.poll();

			if (current.sec >= S)
				break;
			if (current.r == X - 1 && current.c == Y - 1)
				break;

			for (int i = 0; i < 4; i++) {
				int nr = current.r + dr[i];
				int nc = current.c + dc[i];

				if (isIn(nr, nc) && MAP[nr][nc] == 0) {
					pq.add(new Virus(nr, nc, current.num, current.sec + 1));
					MAP[nr][nc] = current.num;
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
