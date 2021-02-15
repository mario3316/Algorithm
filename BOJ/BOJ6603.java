import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {

	static int N;
	static int[] input;
	static int[] output = new int[6];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			String str = br.readLine();

			if (str.equals("0"))
				break;
			else {
				st = new StringTokenizer(str);
				N = Integer.parseInt(st.nextToken());
				input = new int[N];

				for (int i = 0; i < N; i++) {
					input[i] = Integer.parseInt(st.nextToken());
				}

				nCr(0, 0);
				sb.append('\n');
			}
		}

		System.out.print(sb);
	}

	static void nCr(int start, int cnt) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(output[i]).append(" ");
			}
			sb.append('\n');
			return;
		} else {
			for (int i = start; i < N; i++) {
				output[cnt] = input[i];
				nCr(i + 1, cnt + 1);
			}
		}
	}

}
