import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1715 {

	static int N;
	static int sum = 0;
	static PriorityQueue<Integer> Q = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer a, Integer b) {
			return a - b;
		}
	});

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < N; i++)
			Q.offer(sc.nextInt());
		// 합쳐 나가면서 우선순위 큐 에서 가장 작은 2개의 묶음을 골라야 함
		// 카드 묶음이 1개가 될때까지 반복

		solve();
		System.out.println(sum);
	}

	static void solve() {
		while (Q.size() > 1) {
			int a = Q.poll();
			int b = Q.poll();
			Q.offer(a + b);
			sum += a + b;
		}
	}

}
