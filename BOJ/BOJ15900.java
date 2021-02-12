import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15900 {
	// 인접행렬 -> 메모리 초과
	// Node 클래스 ArrayList -> 시간 초과
	static int N;
	static int sum = 0;

	static ArrayList<ArrayList<Integer>> Tree = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// Scanner -> 시간초과
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			Tree.add(new ArrayList<>());
		} // 트리 생성
		visited = new boolean[N + 1];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			Tree.get(a).add(b);
			Tree.get(b).add(a);
		}

		visited[1] = true;
		DFS(1, 0); // 1번 루트노드부터 시작

		if (sum % 2 == 0) { // 모든 Leaf Node의 깊이의 합이 짝수이면 성원이가 지고, 홀수 이면 성원이가
							// 이긴다.
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}

	static void DFS(int from, int depth) {
		// 현재 노드와 이어져 있고 방문하지 않았으면 방문

		for (int next : Tree.get(from)) {
			if (!visited[next]) {
				visited[next] = true;
				DFS(next, depth + 1);
				visited[next] = false;
			}
		}

		// 더이상 방문할 노드가 없으면 총합에 자신의 depth를 더하고 return
		// 하지만 Leaf Node의 깊이만 총합에 더해야 하므로 Leaf Node인지를 검사 (연결된 노드가 부모만 있어야 하므로
		// size == 1)

		if (Tree.get(from).size() == 1)
			sum += depth;
	}

}
