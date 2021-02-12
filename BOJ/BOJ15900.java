import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15900 {
	// 인접행렬 -> 메모리 초과
	static class Node {
		int num;
		ArrayList<Node> next;

		Node(int num) {
			this.num = num;
			next = new ArrayList<Node>();
		}
	}

	static int N;
	static Node[] tree;
	static boolean[] visited; // 방문 여부 저장
	static int sum = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tree = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new Node(i);
		}
		visited = new boolean[N + 1];

		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			tree[a].next.add(tree[b]);
			tree[b].next.add(tree[a]);
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
		int linkCnt = tree[from].next.size();
		for (int i = 0; i < linkCnt; i++) {
			int nodeNum = tree[from].next.get(i).num;
			if (!visited[nodeNum]) {
				visited[i] = true;
				DFS(nodeNum, depth + 1);
				visited[i] = false;
			}
		}

		// 더이상 방문할 노드가 없으면 총합에 자신의 depth를 더하고 return
		// 하지만 Leaf Node의 깊이만 총합에 더해야 하므로 Leaf Node인지를 검사 (연결된 노드가 부모만 있어야 하므로
		// size == 1)

		if (tree[from].next.size() == 1)
			sum += depth;
	}

}
