import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18428 {

	static int N;
	static char[][] MAP;
	static int num;
	static int[] output = new int[3];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean answer = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		MAP = new char[N][N];
		num = N * N;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				MAP[i][j] = st.nextToken().charAt(0);
			}
		}

		Comb(0, 0);
		if (answer)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	static void Comb(int start, int cnt) {
		if (cnt == 3) {
			if (play())
				answer = true;
			return;
		} else {
			for (int i = start; i < num; i++) {
				int r = i / N;
				int c = i % N;

				if (MAP[r][c] == 'X') {
					output[cnt] = i;
					Comb(i + 1, cnt + 1);
				} else
					Comb(i + 1, cnt);
			}
		}
	}

	static boolean play() {
		boolean flag = true;
		char[][] tmap = new char[N][N];

		for (int i = 0; i < N; i++)
			tmap[i] = MAP[i].clone();

		for (int i = 0; i < 3; i++) {
			int r = output[i] / N;
			int c = output[i] % N;
			tmap[r][c] = 'O';
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (tmap[i][j] == 'T') {
					if (!check(i, j, tmap))
						flag = false;
				}
			}
		}
		return flag;
	}

	static boolean check(int r, int c, char[][] tmap) {

		for (int i = 0; i < 4; i++) {
			int nr = r;
			int nc = c;
			while (true) {
				nr += dr[i];
				nc += dc[i];

				if (!isIn(nr, nc) || tmap[nr][nc] == 'O')
					break;
				if (tmap[nr][nc] == 'S')
					return false;
			}
		}
		return true;
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
