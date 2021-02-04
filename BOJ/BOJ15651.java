import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {

	static int N, M;
	static int[] output;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		output = new int[M];

		Comb(0);
		System.out.println(sb);
	}

	public static void Comb(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(output[i]).append(' ');
			}
			sb.append('\n');
			return;
		} else {
			for (int i = 1; i <= N; i++) {
				output[cnt] = i;
				Comb(cnt + 1);
			}
		}
	}

}
