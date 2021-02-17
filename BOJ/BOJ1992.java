import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1992 {

	static int N;
	static char[][] MAP;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		MAP = new char[N][N];

		for (int i = 0; i < N; i++) {
			MAP[i] = br.readLine().toCharArray();
		}

		divide(0, 0, N);
	}

	static void divide(int r, int c, int len) {

		if (isSame(r, c, len)) {
			System.out.print(MAP[r][c]);
			return;
		} else {
			System.out.print("(");
			int new_len = len / 2;
			divide(r, c, new_len);
			divide(r, c + new_len, new_len);
			divide(r + new_len, c, new_len);
			divide(r + new_len, c + new_len, new_len);
			System.out.print(")");
		}
	}

	static boolean isSame(int r, int c, int len) {
		char temp = MAP[r][c];

		for (int i = r; i < r + len; i++) {
			for (int j = c; j < c + len; j++) {
				if (MAP[i][j] != temp) {
					return false;
				}
			}
		}

		return true;
	}

}
