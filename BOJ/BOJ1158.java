package algo0209;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1158 {

	static int N, K;
	static ArrayList<Integer> origin = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		for (int i = 1; i <= N; i++)
			origin.add(i);

		int step = 0;
		int cnt = 0;
		sb.append("<");
		while (!origin.isEmpty()) {
			step = (step + K - 1) % origin.size();
			cnt++;

			if (cnt < N)
				sb.append(origin.remove(step) + ", ");
			else
				sb.append(origin.remove(step) + ">");
		}

		System.out.println(sb);
	}

}
