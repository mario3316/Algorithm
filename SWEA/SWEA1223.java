import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class SWEA1223 {

	static int T = 10;
	static int N;
	static char[] input;
	static char[] output;
	static HashMap<Character, Integer> M = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		M.put('+', 0);
		M.put('*', 1); // �켱���� �ο�

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			input = new char[N];
			output = new char[N];
			input = br.readLine().toCharArray();

			System.out.printf("#%d %d\n", i, solve());
		}
	}

	static int solve() {
		Stack<Integer> S = new Stack<>();
		Postfix();

		for (int i = 0; i < output.length; i++) {
			if (output[i] >= '0' && output[i] <= '9') {
				S.push((int) output[i] - '0');
			} else {
				int a, b;
				b = S.peek();
				S.pop();
				a = S.peek();
				S.pop();

				switch (output[i]) {
				case '+':
					S.push(a + b);
					break;
				case '*':
					S.push(a * b);
					break;
				}
			}
		}

		return S.peek();
	}

	static void Postfix() {
		int idx = 0;
		Stack<Character> S = new Stack<>();

		for (int i = 0; i < input.length; i++) {
			if (input[i] >= '0' && input[i] <= '9') {
				output[idx++] = input[i];
			} else {
				if (S.isEmpty()) {
					S.push(input[i]);
				} else { // �ִ� ���� �켱�������� ���ų� ���� ����� ��� pop �ѵ� push
					while (!S.isEmpty() && M.get(input[i]) <= M.get(S.peek())) {
						output[idx++] = S.peek();
						S.pop();
					}
					S.push(input[i]);
				}
			}
		}

		while (!S.empty()) { // ������ ��� Pop�ؼ� ���
			output[idx++] = S.peek();
			S.pop();
		}
	}

}
