import java.util.Scanner;

public class BOJ1074 {
	static int N, r, c;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		int len = (int) Math.pow(2, N); // 2^N 길이를 구함
		Recursion(0, 0, len);
		sc.close();
	}

	static void Recursion(int nr, int nc, int len) {
		if (nr == r && nc == c) { // 목표 좌표 찾았으면 종료
			System.out.println(cnt);
			return;
		} else {
			int new_len = len / 2; // 길이를 반씩 줄여줌

			// r,c 가 해당 하는 범위의 사분면만 재귀
			if (nr <= r && r < nr + len && nc <= c && c < nc + len) {
				Recursion(nr, nc, new_len);
				Recursion(nr, nc + new_len, new_len);
				Recursion(nr + new_len, nc, new_len);
				Recursion(nr + new_len, nc + new_len, new_len);
			} else // 건너뛴 사분면의 개수 카운트
				cnt += len * len;
		}

	}

}
