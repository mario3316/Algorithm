import java.util.Arrays;
import java.util.Scanner;

public class BOJ1342 {

	static char[] input, output;
	static boolean[] visited;
	static int answer = 0;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.next().toCharArray();

		N = input.length;
		visited = new boolean[N];
		output = new char[N];

		Permutation(0);

		System.out.println(answer / findRepetition());
	}

	static void Permutation(int cnt) {
		if (cnt == N) {
			answer++;
		} else {
			for (int i = 0; i < N; i++) {
				if (cnt == 0) {
					if (!visited[i]) {
						visited[i] = true;
						output[cnt] = input[i];
						Permutation(cnt + 1);
						visited[i] = false;
					}
				} else {
					if (!visited[i]) {
						if (input[i] != output[cnt - 1]) {
							visited[i] = true;
							output[cnt] = input[i];
							Permutation(cnt + 1);
							visited[i] = false;
						}
					}
				}
			}
		}
	}

	static int findRepetition() {
		int result = 1;

		Arrays.sort(input);
		char index = input[0];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			if (index == input[i])
				cnt++;
			else {
				result *= factorial(cnt);
				cnt = 1;
				index = input[i];
			}
		}

		result *= factorial(cnt);

		return result;
	}

	static int factorial(int n) {
		int result = 1;

		while (n > 1) {
			result *= n;
			n--;
		}

		return result;
	}

}