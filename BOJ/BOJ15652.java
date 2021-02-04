import java.util.Scanner;

public class BOJ15652 {

	static int N, M;
	static int[] output;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		output = new int[M];

		Comb(0, 1);
		System.out.print(sb);
		sc.close();
	}

	public static void Comb(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(output[i]).append(' ');
			}
			sb.append('\n');
			return;
		} else {
			for (int i = start; i <= N; i++) {
				output[cnt] = i;
				Comb(cnt + 1, i);
			}
		}
	}

}
