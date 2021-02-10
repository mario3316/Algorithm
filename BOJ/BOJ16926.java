import java.util.Scanner;

public class BOJ16926 {
	static int N, M, R;
	static int[][] MAP;
	static int rotateCnt;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 }; // 우 하 좌 상

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		MAP = new int[N][M];
		rotateCnt = Math.min(N, M) / 2;

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				MAP[i][j] = sc.nextInt();

		int r = 0, c = 0, rLen = N, cLen = M;
		while (rotateCnt > 0) {
			for (int i = 0; i < R; i++) {
				rotate(r, c, rLen, cLen);
			}
			r++;
			c++;
			rLen -= 2;
			cLen -= 2;
			rotateCnt--;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(MAP[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void rotate(int r, int c, int rLen, int cLen) {
		int ir = r;
		int ic = c;
		int dir = 0;
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		int temp = MAP[r][c];

		while (!(nr == ir && nc == ic)) { // 처음으로 돌아올때까지
			nr = r + dr[dir];
			nc = c + dc[dir];
			if (nr >= ir && nr < ir + rLen && nc >= ic && nc < ic + cLen) { // 다음이 테두리에 있으면
				MAP[r][c] = MAP[nr][nc];
				r = nr;
				c = nc;
			} else { // 테두리를 벗어나면 방향 바꿈
				dir = (dir + 1) % 4;
			}
		}
		MAP[ir + 1][c] = temp;
	}

}
