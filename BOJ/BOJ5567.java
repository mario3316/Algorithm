import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ5567 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> G = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i <= N; i++) {
			G.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			G.get(from).add(to);
			G.get(to).add(from);
		}

		System.out.println(BFS(1));
	}

	static int BFS(int start) {
		int result = 0;
		Queue<int[]> Q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		Q.add(new int[] { start, 0 }); // 0 : node ¹øÈ£ , 1 : ±íÀÌ
		visited[start] = true;

		while (!Q.isEmpty()) {
			int[] current = Q.poll();

			if (current[1] > 1)
				break;

			for (int to : G.get(current[0])) {
				if (!visited[to]) {
					Q.add(new int[] { to, current[1] + 1 });
					visited[to] = true;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (visited[i])
				result++;
		}

		return result;
	}
}
