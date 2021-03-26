import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ9205 {

	static class Edge {
		int num, weight;

		Edge(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}

	static int T, N;
	static int[][] Point;
	static boolean[] visited;
	static ArrayList<Edge>[] edges;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			N = sc.nextInt() + 2;
			Point = new int[N][2];
			edges = new ArrayList[N];
			visited = new boolean[N];

			for (int i = 0; i < N; i++)
				edges[i] = new ArrayList<Edge>();

			for (int i = 0; i < N; i++) {
				Point[i][0] = sc.nextInt();
				Point[i][1] = sc.nextInt();
			}

			for (int i = 0; i < N - 1; i++) {
				int r = Point[i][0];
				int c = Point[i][1];

				for (int j = i + 1; j < N; j++) {
					int weight = Math.abs(Point[j][0] - r)
							+ Math.abs(Point[j][1] - c);

					edges[i].add(new Edge(j, weight));
					edges[j].add(new Edge(i, weight));
				}
			}

			BFS();

			if (visited[N - 1])
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}

	static void BFS() {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(0);
		visited[0] = true;

		while (!Q.isEmpty()) {
			int current = Q.poll();

			for (Edge e : edges[current]) {
				if (!visited[e.num] && e.weight <= 1000) {
					Q.add(e.num);
					visited[e.num] = true;
				}
			}
		}
	}

}
