import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15686 {

	static class Chicken {
		int r, c;

		public Chicken(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M;
	static int[][] MAP;
	static Chicken[] C = new Chicken[13];
	static int[] output;
	static int idx = 0;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		output = new int[M];
		MAP = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				if (MAP[i][j] == 2) {
					C[idx++] = new Chicken(i, j);
				}
			}
		}

		Comb(0, 0);
		System.out.println(answer);
	}

	static void Comb(int start, int cnt) {
		if (cnt == M) {
			answer = Math.min(answer, calcDist());
			return;
		} else {
			for (int i = start; i < idx; i++) {
				output[cnt] = i;
				Comb(i + 1, cnt + 1);
			}
		}
	}

	static int calcDist() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (MAP[i][j] == 1) {
					int min = Integer.MAX_VALUE;
					for (int k = 0; k < M; k++) {
						Chicken c = C[output[k]];
						min = Math.min(min, Math.abs(i - c.r) + Math.abs(j - c.c));
					}
					sum += min;
				}
			}
		}
		return sum;
	}

}
