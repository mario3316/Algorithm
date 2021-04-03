import java.util.Scanner;

public class BOJ3020 {

	static int N, H;
	static int[] up; // 종유석
	static int[] down; // 석순
	static int min = Integer.MAX_VALUE;
	static int ansCount = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		H = sc.nextInt();
		up = new int[H + 1];
		down = new int[H + 1];

		// 각 구간별로 끝나는 구간에 표시
		for (int i = 0; i < N / 2; i++) {
			down[sc.nextInt()]++;
			up[sc.nextInt()]++;
		}

		// 아래부터 모두 이어줌
		int[] upTotal = new int[H + 1];
		int[] downTotal = new int[H + 1];
		for (int i = 1; i <= H; i++) {
			downTotal[i] = downTotal[i - 1] + down[i];
			upTotal[i] = upTotal[i - 1] + up[i];
		}

		for (int i = 1; i <= H; i++) {
			int cnt = 0;

			cnt += N / 2 - downTotal[i - 1]; // 높이가 i보다 작은 석순의 개수를 전체에서 뺌
			cnt += N / 2 - upTotal[H - i]; // 높이 H-i 이하인 종유석을 전체에서 뺀 종유석 개수

			if (cnt < min) {
				min = cnt;
				ansCount = 1;
			} else if (cnt == min) {
				ansCount++;
			}
		}

		System.out.println(min + " " + ansCount);
	}

}
