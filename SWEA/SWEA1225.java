import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {

	static int T = 10;
	static int N;
	static Queue<Integer> Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int i = 1; i <= T; i++) {
			Q = new LinkedList<>();
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < 8; j++) {
				Q.offer(Integer.parseInt(st.nextToken()));
			}

			solve();

			while (!Q.isEmpty()) {
				sb.append(Q.poll()).append(' ');
			}

			System.out.printf("#%d %s\n", i, sb);
		}
	}

	public static void solve() {
		while (true) {
			for (int i = 1; i <= 5; i++) {
				int num = Q.poll();
				if (num - i <= 0) {
					Q.offer(0);
					return;
				} else {
					Q.offer(num - i);
				}
			}
		}
	}

}
