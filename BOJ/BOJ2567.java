import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2567 {

	static int N;
	static int SIZE = 100;
	static boolean[][] MAP = new boolean[SIZE][SIZE];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int total = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			for (int j = r; j < r + 10; j++) {
				for (int k = c; k < c + 10; k++) {
					MAP[j][k] = true;
				}
			}
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (MAP[i][j]) {
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];

						if (isIn(nr, nc) && !MAP[nr][nc]) {
							total++;
						}
						if (!isIn(nr, nc))
							total++;
					}
				}
			}
		}

		System.out.println(total);
	}

	public static boolean isIn(int r, int c) {
		if (r >= 0 && r < SIZE && c >= 0 && c < SIZE)
			return true;
		else
			return false;
	}

}
