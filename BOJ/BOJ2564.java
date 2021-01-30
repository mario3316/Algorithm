import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2564 {

	static int rLength;
	static int cLength;
	static int N;
	static int myR;
	static int myC;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] MAP;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	public static int solve() {
		int minDist = 0;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[rLength][cLength];
			if (myR == 0 || myR == rLength - 1) {
				visited[myR][myC] = true;
				int left = search(myR, myC - 1, i, 0) + 1;
				int right = search(myR, myC + 1, i, 0) + 1;
				minDist += Math.max(left, right);
			} else {
				visited[myR][myC] = true;
				int up = search(myR - 1, myC, i) + 1;
				int down = search(myR + 1, myC, i) + 1;
				minDist += Math.max(up, down);
			}

		}

		return minDist;
	}

	public static int search(int r, int c, int target, int cnt) {
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isIn(nr, nc) && !visited[nr][nc]) {
				r = nr;
				c = nc;
				cnt++;
			}
		}

		return cnt;
	}

	public static boolean isIn(int r, int c) {
		if (r >= 0 && r < rLength && c >= 0 && c < cLength) {
			if (r == 0 || r == rLength - 1 || c == 0 || c == cLength - 1)
				return true;
			else
				return false;
		} else
			return false;
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		cLength = Integer.parseInt(st.nextToken());
		rLength = Integer.parseInt(st.nextToken());
		MAP = new int[rLength][cLength];

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (l == 1) {
				MAP[0][d] = i + 1;
			} else if (l == 2) {
				MAP[rLength - 1][d] = i + 1;
			} else if (l == 3) {
				MAP[d][0] = i + 1;
			} else {
				MAP[d][cLength - 1] = i + 1;
			}
		}

		st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		if (l == 1) {
			myR = 0;
			myC = d;
		} else if (l == 2) {
			myR = rLength - 1;
			myC = d;
		} else if (l == 3) {
			myR = d;
			myC = 0;
		} else {
			myR = d;
			myC = cLength - 1;
		}
	}

}
