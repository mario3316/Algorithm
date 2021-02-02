import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {

	static int N;
	static int SIZE = 100;
	static boolean[][] MAP = new boolean[SIZE][SIZE];
	static int total = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			for (int j = r; j < r + 10; j++) {
				for (int k = c; k < c + 10; k++) {
					MAP[j][k] = true;
				}
			}
		}

		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++) {
				if (MAP[i][j])
					total++;
			}

		System.out.println(total);
	}

}
