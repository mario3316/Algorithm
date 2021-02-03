import java.util.Scanner;

public class BOJ15650 {

	static int N, M;
	static int[] output;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		output = new int[M];

		Comb(0, 1);
	}

	public static void Comb(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		} else {
			for (int i = start; i <= N; i++) {
				output[cnt] = i;
				Comb(cnt + 1, i + 1);
			}
		}
	}

}
