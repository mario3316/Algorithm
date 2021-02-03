import java.util.Scanner;

public class BOJ15649 {

	static int N, M;
	static boolean[] visited;
	static int[] output;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		output = new int[M];
		visited = new boolean[N + 1];

		Perm(0);
	}

	public static void Perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		} else {
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					output[cnt] = i;
					visited[i] = true;
					Perm(cnt + 1);
					visited[i] = false;
				}
			}
		}
	}

}
