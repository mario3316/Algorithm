import java.util.Scanner;

public class BOJ2839 {

	static int N;
	static int min = 5001;
	static int minThree, minFive;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		int F = N / 5;
		int T = N / 3;

		for (int i = F; i >= 0; i--) {
			for (int j = T; j >= 0; j--) {
				if (N == i * 5 + j * 3) {
					min = Math.min(min, i + j);
				}
			}
		}

		if (min == 5001)
			System.out.println("-1");
		else
			System.out.println(min);

	}
}
