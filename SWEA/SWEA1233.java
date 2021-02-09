package algo0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1233 {

	static class Node {
		int num, op, left, right;

		Node(int num, int op, int left, int right) {
			this.num = num;
			this.op = op;
			this.left = left;
			this.right = right;
		}
	}

	static int T = 10;
	static int N;
	static ArrayList<Node> Tree = new ArrayList<>();
	static boolean flag;
	static boolean NumorOp; // false 이면 숫자 true 이면 연산자

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			Tree = new ArrayList<>();
			Tree.add(new Node(0, 0, 0, 0)); // dummy

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				int num = Integer.parseInt(st.nextToken());
				int op;
				String temp = st.nextToken();
				if (temp.charAt(0) == '+' || temp.charAt(0) == '-' || temp.charAt(0) == '*' || temp.charAt(0) == '/')
					op = -1;
				else
					op = Integer.parseInt(temp);
				int left = 0, right = 0;
				if (st.hasMoreTokens())
					left = Integer.parseInt(st.nextToken());
				if (st.hasMoreTokens())
					right = Integer.parseInt(st.nextToken());

				Node n = new Node(num, op, left, right);
				Tree.add(n);
			}

			flag = true;
			NumorOp = false;
			Inorder(Tree.get(1));
			if (flag)
				System.out.printf("#%d 1\n", t);
			else
				System.out.printf("#%d 0\n", t);
		}

	}

	static void Inorder(Node N) {
		if (N.num == 0) {
			return;
		}

		Inorder(Tree.get(N.left));
		if (!NumorOp && isOp(N.op) || NumorOp && !isOp(N.op)) {
			flag = false;
			return;
		} else {
			NumorOp = !NumorOp;
		}
		Inorder(Tree.get(N.right));
	}

	static boolean isOp(int op) {
		if (op == -1)
			return true;
		else
			return false;
	}
}
