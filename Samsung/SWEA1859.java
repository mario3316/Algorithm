import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1859 {

	static int N;

	public static long solve(int[] arr) {
		long answer = 0;

		int len = arr.length;
		int current = arr[len - 1];

		for (int i = len - 1; i > 0; i--) {
			if (current > arr[i - 1]) {
				answer += current - arr[i - 1];
			} else {
				current = arr[i - 1];
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int days = Integer.parseInt(br.readLine());
			int[] arr = new int[days];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < days; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			System.out.printf("#%d %d\n", i + 1, solve(arr));
		}

	}

}
