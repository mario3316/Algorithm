import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ15665 {
	static int N, M;
	static int[] input;
	static int[] output;
	static LinkedHashSet<String> set = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

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
		Perm(0, "");

		for (String s : set) {
			sb.append(s).append('\n');
		}

		System.out.print(sb);
	}

	public static void Perm(int cnt, String str) {
		if (cnt == M) {
			set.add(str);
			return;
		} else {
			for (int i = 0; i < N; i++) {
				output[cnt] = input[i];
				Perm(cnt + 1, str + input[i] + " ");
			}
		}
	}

}
