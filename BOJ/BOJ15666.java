import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ15666 {
	static int N, M;
	static int[] input;
	static int[] output;
	static StringBuilder sb;
	static LinkedHashSet<String> S = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		output = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);
		Comb(0, 0);

		sb = new StringBuilder();
		for (String s : S) {
			sb.append(s).append('\n');
		}

		System.out.print(sb);
	}

	public static void Comb(int cnt, int start) {
		if (cnt == M) {
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(output[i]).append(" ");
			}
			S.add(new String(sb));
			return;
		} else {
			for (int i = start; i < N; i++) {
				output[cnt] = input[i];
				Comb(cnt + 1, i);
			}
		}
	}

}
