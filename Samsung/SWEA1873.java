import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1873 {

	static int T;
	static int H, W, O;
	static char[][] MAP;
	static char[] Order;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			MAP = new char[H][W];

			for (int j = 0; j < H; j++) {
				MAP[j] = br.readLine().toCharArray();
			}

			O = Integer.parseInt(br.readLine());
			Order = new char[O];
			Order = br.readLine().toCharArray();

			solve();

			System.out.printf("#%d ", i);
			for (int j = 0; j < H; j++) {
				for (int k = 0; k < W; k++) {
					System.out.print(MAP[j][k]);
				}
				System.out.println();
			}
		}
	}

	public static void solve() {
		int r = 0, c = 0, dir = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (MAP[i][j] == '^') {
					r = i;
					c = j;
					dir = 0;
					break;
				}
				if (MAP[i][j] == 'v') {
					r = i;
					c = j;
					dir = 1;
					break;
				}
				if (MAP[i][j] == '<') {
					r = i;
					c = j;
					dir = 2;
					break;
				}
				if (MAP[i][j] == '>') {
					r = i;
					c = j;
					dir = 3;
					break;
				}
			}
		} // 초기 탱크 위치 탐색

		for (int i = 0; i < O; i++) {
			int nr = 0, nc = 0;
			switch (Order[i]) {
			case 'U':
				dir = 0;
				nr = r + dr[dir];
				nc = c + dc[dir];
				if (isIn(nr, nc) && MAP[nr][nc] == '.') {
					MAP[nr][nc] = '^';
					MAP[r][c] = '.';
					r = nr;
					c = nc; // 방향 바꾸고 이동, 이동시 지나온길 평지로 수정
				} else {
					MAP[r][c] = '^'; // 이동 못하면 방향만 바꿈
				}
				break;
			case 'D':
				dir = 1;
				nr = r + dr[dir];
				nc = c + dc[dir];
				if (isIn(nr, nc) && MAP[nr][nc] == '.') {
					MAP[nr][nc] = 'v';
					MAP[r][c] = '.';
					r = nr;
					c = nc; // 방향 바꾸고 이동, 이동시 지나온길 평지로 수정
				} else {
					MAP[r][c] = 'v'; // 이동 못하면 방향만 바꿈
				}
				break;
			case 'L':
				dir = 2;
				nr = r + dr[dir];
				nc = c + dc[dir];
				if (isIn(nr, nc) && MAP[nr][nc] == '.') {
					MAP[nr][nc] = '<';
					MAP[r][c] = '.';
					r = nr;
					c = nc; // 방향 바꾸고 이동, 이동시 지나온길 평지로 수정
				} else {
					MAP[r][c] = '<'; // 이동 못하면 방향만 바꿈
				}
				break;
			case 'R':
				dir = 3;
				nr = r + dr[dir];
				nc = c + dc[dir];
				if (isIn(nr, nc) && MAP[nr][nc] == '.') {
					MAP[nr][nc] = '>';
					MAP[r][c] = '.';
					r = nr;
					c = nc; // 방향 바꾸고 이동, 이동시 지나온길 평지로 수정
				} else {
					MAP[r][c] = '>'; // 이동 못하면 방향만 바꿈
				}
				break;
			case 'S':
				shoot(r, c, dir);
				break;
			}

		}
	}

	public static void shoot(int r, int c, int dir) {
		while (isIn(r, c)) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (!isIn(nr, nc))
				break;

			if (MAP[nr][nc] == '*') {
				MAP[nr][nc] = '.';
				break;
			} else if (MAP[nr][nc] == '#')
				break;

			r = nr;
			c = nc;
		}
	}

	public static boolean isIn(int r, int c) {
		if (r >= 0 && r < H && c >= 0 && c < W)
			return true;
		else
			return false;
	}

}
