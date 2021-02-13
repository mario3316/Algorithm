import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ18352 {

	static int N, M, K, X;
	static ArrayList<ArrayList<Integer>> Graph = new ArrayList<>();
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();

		for (int i = 0; i < N + 1; i++) {
			Graph.add(new ArrayList<>());
		}
		dist = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			Graph.get(a).add(b);
		}

		BFS(X);

		boolean flag = true;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				System.out.println(i);
				flag = false;
			}
		}

		if (flag)
			System.out.println("-1");
	}

	static void BFS(int n) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(n);
		visited[n] = true;

		while (!Q.isEmpty()) {
			int current = Q.poll();

			for (int next : Graph.get(current)) {
				if (!visited[next]) {
					dist[next] = dist[current] + 1;
					visited[next] = true;
					Q.offer(next);
				}
			}
		}
	}

}
