import java.util.Scanner;

public class BOJ1074 {
	static int N, r, c;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		int len = (int) Math.pow(2, N); // 2^N ���̸� ����
		Recursion(0, 0, len);
		sc.close();
	}

	static void Recursion(int nr, int nc, int len) {
		if (nr == r && nc == c) { // ��ǥ ��ǥ ã������ ����
			System.out.println(cnt);
			return;
		} else {
			int new_len = len / 2; // ���̸� �ݾ� �ٿ���

			// r,c �� �ش� �ϴ� ������ ��и鸸 ���
			if (nr <= r && r < nr + len && nc <= c && c < nc + len) {
				Recursion(nr, nc, new_len);
				Recursion(nr, nc + new_len, new_len);
				Recursion(nr + new_len, nc, new_len);
				Recursion(nr + new_len, nc + new_len, new_len);
			} else // �ǳʶ� ��и��� ���� ī��Ʈ
				cnt += len * len;
		}

	}

}
