import java.util.Scanner;

public class BOJ9663 {

	static int N;
	static int[] col;
	static int tot = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];

		NQueen(0);
		System.out.println(tot);
		sc.close();
	}

	public static void NQueen(int cnt) {
		if (cnt == N) {
			tot++;
			return;
		} else {
			for (int i = 0; i < N; i++) {
				if (isPossible(i, cnt)) {
					col[cnt] = i;
					NQueen(cnt + 1);
				}
			}
		}
	}

	public static boolean isPossible(int r, int c) {
		if (c == 0) // ó���� ������ ����
			return true;
		else {
			for (int i = 0; i < c; i++) {
				if (col[i] == r) // ���� ���� �ְų�
					return false;
				if (Math.abs(col[i] - r) == Math.abs(i - c)) // �밢���� ������ false (
																// ���Ⱑ 1�ΰ� )
					return false;
			}
		}
		return true;
	}
}
