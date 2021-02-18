package algo0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1247 {

	static int T, N;
	static int[] p;
	static int comR, comC;
	static int homeR, homeC;
	static int[][] customers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			customers = new int[N][2];
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			st = new StringTokenizer(br.readLine());
			comR = Integer.parseInt(st.nextToken());
			comC = Integer.parseInt(st.nextToken());
			homeR = Integer.parseInt(st.nextToken());
			homeC = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}

			int min = Integer.MAX_VALUE;
			do {
				min = Math.min(min, calcDist());
			} while (next_permutation());

			System.out.printf("#%d %d\n", t, min);
		}

	}

	static int calcDist() {
		int sum = 0;
		sum += Math.abs(comR - customers[p[0]][0]) + Math.abs(comC - customers[p[0]][1]);
		sum += Math.abs(homeR - customers[p[N - 1]][0]) + Math.abs(homeC - customers[p[N - 1]][1]);

		for (int i = 0; i < N - 1; i++) {
			sum += Math.abs(customers[p[i]][0] - customers[p[i + 1]][0])
					+ Math.abs(customers[p[i]][1] - customers[p[i + 1]][1]);
		}

		return sum;
	}

	static boolean next_permutation() {
		int i = N - 1;

		while (i > 0 && p[i - 1] >= p[i])
			i--;

		if (i == 0)
			return false;
		else {
			int j = N - 1;
			while (p[i - 1] >= p[j])
				j--;

			swap(i - 1, j);

			int k = N - 1;

			while (i < k) {
				swap(i, k);
				i++;
				k--;
			}

			return true;
		}
	}

	static void swap(int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}

}
