import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15900 {
	// ������� -> �޸� �ʰ�
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
	static boolean[] visited; // �湮 ���� ����
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
		DFS(1, 0); // 1�� ��Ʈ������ ����

		if (sum % 2 == 0) { // ��� Leaf Node�� ������ ���� ¦���̸� �����̰� ����, Ȧ�� �̸� �����̰�
							// �̱��.
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}

	static void DFS(int from, int depth) {
		// ���� ���� �̾��� �ְ� �湮���� �ʾ����� �湮
		int linkCnt = tree[from].next.size();
		for (int i = 0; i < linkCnt; i++) {
			int nodeNum = tree[from].next.get(i).num;
			if (!visited[nodeNum]) {
				visited[i] = true;
				DFS(nodeNum, depth + 1);
				visited[i] = false;
			}
		}

		// ���̻� �湮�� ��尡 ������ ���տ� �ڽ��� depth�� ���ϰ� return
		// ������ Leaf Node�� ���̸� ���տ� ���ؾ� �ϹǷ� Leaf Node������ �˻� (����� ��尡 �θ� �־�� �ϹǷ�
		// size == 1)

		if (tree[from].next.size() == 1)
			sum += depth;
	}

}
