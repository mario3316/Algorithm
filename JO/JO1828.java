import java.util.Arrays;
import java.util.Scanner;

public class JO1828 {

	static class C implements Comparable<C> {
		int low, high;

		public C(int low, int high) {
			this.low = low;
			this.high = high;
		}

		public int compareTo(C o) {
			return this.high - o.high;
		}
	}

	static int N;
	static int cnt = 1;
	static C[] chemicals;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		chemicals = new C[N];

		for (int i = 0; i < N; i++) {
			chemicals[i] = new C(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(chemicals);
		C current = chemicals[0];

		for (int i = 1; i < N; i++) {
			if (current.high < chemicals[i].low) { // 온도가 안겹치면 카운트 증가
				current = chemicals[i];
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}
