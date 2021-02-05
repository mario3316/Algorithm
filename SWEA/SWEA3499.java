import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA3499 {
	static int T;
	static int N;
	static String[] input;
	static String[] output;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			input = new String[N];
			output = new String[N];

			input = br.readLine().split(" ");

			int middle;
			if (N % 2 == 0) {
				middle = N / 2;
			} else {
				middle = N / 2 + 1;
			}

			int idx = 0;
			for (int j = 0; j < middle; j++) {
				output[idx] = input[j];
				idx += 2;
			}

			idx = 1;
			for (int j = middle; j < N; j++) {
				output[idx] = input[j];
				idx += 2;
			}

			StringBuilder sb = new StringBuilder();
			for (String s : output) {
				sb.append(s).append(' ');
			}

			System.out.printf("#%d %s\n", i, new String(sb));
		}
	}

}
