import java.util.Scanner;

public class SWEA11387 {

	static int T;
	static int D, L, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			D = sc.nextInt();
			L = sc.nextInt();
			N = sc.nextInt();

			int n = 0;
			int damage = 0;
			while (n != N) {
				damage += D + D / 100 * n * L;
				n++;
			}

			System.out.printf("#%d %d\n", i, damage);
		}
	}

}
