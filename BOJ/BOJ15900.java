import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15900 {
	// ������� -> �޸� �ʰ�
	// Node Ŭ���� ArrayList -> �ð� �ʰ�
	static int N;
	static int sum = 0;

	static ArrayList<ArrayList<Integer>> Tree = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// Scanner -> �ð��ʰ�
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			Tree.add(new ArrayList<>());
		} // Ʈ�� ����
		visited = new boolean[N + 1];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			Tree.get(a).add(b);
			Tree.get(b).add(a);
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

		for (int next : Tree.get(from)) {
			if (!visited[next]) {
				visited[next] = true;
				DFS(next, depth + 1);
				visited[next] = false;
			}
		}

		// ���̻� �湮�� ��尡 ������ ���տ� �ڽ��� depth�� ���ϰ� return
		// ������ Leaf Node�� ���̸� ���տ� ���ؾ� �ϹǷ� Leaf Node������ �˻� (����� ��尡 �θ� �־�� �ϹǷ�
		// size == 1)

		if (Tree.get(from).size() == 1)
			sum += depth;
	}

}
