import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {
	static int N, M;
	static int[] input;
	static int[] output;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		output = new int[M];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);
		Perm(0);
		System.out.print(sb);
	}

	public static void Perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(output[i]).append(' ');
			}
			sb.append('\n');
			return;
		} else {
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					output[cnt] = input[i];
					visited[i] = true;
					Perm(cnt + 1);
					visited[i] = false;
				}
			}
		}
	}

}
