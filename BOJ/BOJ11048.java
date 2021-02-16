import java.util.Scanner;

public class BOJ11047 {

	static int N, K;
	static int[] value;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		value = new int[N];

		for (int i = 0; i < N; i++) {
			value[i] = sc.nextInt();
		}

		// 가치가 높은 동전부터 들어가는지 확인
		for (int i = N - 1; i >= 0; i--) {
			if (value[i] < K) {
				int div = K / value[i]; // 몇개 들어가는지
				cnt += div; // 사용한 동전 개수 증가
				K -= (value[i] * div); // 남은 돈 계산
			}
		}

		System.out.println(cnt);
	}

}
