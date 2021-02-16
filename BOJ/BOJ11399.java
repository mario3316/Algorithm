import java.util.Arrays;
import java.util.Scanner;

public class BOJ11399 {

	static int N;
	static int[] P;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		P = new int[N];

		for (int i = 0; i < N; i++) {
			P[i] = sc.nextInt();
		}

		Arrays.sort(P); // 빨리뽑는 사람이 앞으로 가야하므로 오름차순 정렬

		for (int i = 1; i < N; i++) {
			P[i] = P[i - 1] + P[i];
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += P[i];
		}

		System.out.println(sum);
	}

}
