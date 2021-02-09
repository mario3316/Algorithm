import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
	static int N, M, V;
	static boolean[][] MAP;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		MAP = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			MAP[a][b] = true;
			MAP[b][a] = true;
		}

		visited = new boolean[N + 1];
		sb = new StringBuilder();
		DFS(V);
		sb.append('\n');

		visited = new boolean[N + 1];
		BFS(V);
		System.out.println(sb);
	}

	static void DFS(int V) {
		visited[V] = true;
		sb.append(V + " ");

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && MAP[V][i]) {
				DFS(i);
			}
		}
		return;
	}

	static void BFS(int V) {
		Queue<Integer> Q = new LinkedList<>();

		Q.offer(V);
		visited[V] = true;
		sb.append(V + " ");

		while (!Q.isEmpty()) {
			int current = Q.poll();

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && MAP[current][i]) {
					Q.offer(i);
					visited[i] = true;
					sb.append(i + " ");
				}
			}
		}

		return;
	}

}
