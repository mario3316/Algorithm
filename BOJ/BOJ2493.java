import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {

	static int N;
	static int[] result;
	static int[] height;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		result = new int[N];
		height = new int[N + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			height[i + 1] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> S = new Stack<>();
		for (int i = N; i > 0; i--) {
			if (S.isEmpty() || height[S.peek()] > height[i]) {
				S.push(i);
			} else {
				while (!S.isEmpty() && height[S.peek()] <= height[i]) {
					result[S.peek() - 1] = i;
					S.pop();
				}
				S.push(i);
			}
		}

		for (int s : result) {
			sb.append(s).append(" ");
		}
		System.out.println(sb);

	}

}
