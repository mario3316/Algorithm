import java.util.Scanner;

public class BOJ13300 {
	static int N, K;
	static int[][] Students = new int[7][2];
	static int sum = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int S = sc.nextInt();
			int grade = sc.nextInt();

			Students[grade][S]++;
		}

		count();
		System.out.println(sum);
	}

	static void count() {
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				sum += Students[i][j] / K;
				if (Students[i][j] % K > 0)
					sum++;
			}
		}
	}

}
