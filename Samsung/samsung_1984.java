import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class samsung_1984 {

	static int N;

	public static int solve(int[] arr) {
		Arrays.sort(arr);

		int sum = 0;
		for (int i = 1; i <= 8; i++) {
			sum += arr[i];
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[10];

			for (int j = 0; j < 10; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int sum = solve(arr);
			System.out.printf("#%d %.0f\n", i + 1, sum / 8.0);

		}
	}

}
