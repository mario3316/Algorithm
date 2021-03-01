import java.util.Arrays;
import java.util.Scanner;

public class BOJ1377 {

	static class Point implements Comparable<Point> {
		int num, index;

		Point(int num, int index) {
			this.num = num;
			this.index = index;
		}

		@Override
		public int compareTo(Point p) {
			return this.num - p.num;
		}
	}

	static int N;
	static Point[] points;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		points = new Point[N + 1];
		points[0] = new Point(-1, 0);

		for (int i = 1; i <= N; i++) {
			points[i] = new Point(sc.nextInt(), i);
		}

		Arrays.sort(points);

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt = Math.max(cnt, points[i].index - i);
		}

		System.out.println(cnt + 1);
	}

}
