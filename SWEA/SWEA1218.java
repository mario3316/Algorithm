import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class SWEA1218 {

	static int T = 10;
	static int N;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N];
			arr = br.readLine().toCharArray();

			System.out.printf("#%d %d\n", i, solve());
		}
	}

	public static int solve() {
		int res = 0;
		Stack<Character> s = new Stack<>();
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		map.put('<', '>');

		for (int i = 0; i < N; i++) {
			if (s.isEmpty()) {
				if (!map.containsKey(arr[i]))
					return 0;
				else
					s.push(arr[i]);
			} else {
				if (map.get(s.peek()) == arr[i]) {
					s.pop();
				} else {
					if (!map.containsKey(arr[i]))
						return 0;
					else
						s.push(arr[i]);
				}
			}
		}

		if (s.size() == 0) {
			res = 1;
		}

		return res;
	}

}
