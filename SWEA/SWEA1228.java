package algo0208;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA1228 {
	static int T = 10;
	static int N, C;
	static ArrayList<Integer> num = new ArrayList<>();
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= T; t++) {
			num.clear();

			N = sc.nextInt();

			for (int i = 0; i < N; i++)
				num.add(sc.nextInt());

			C = sc.nextInt();

			for (int i = 0; i < C; i++) {
				char command = sc.next().charAt(0);

				if (command == 'I') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						num.add(x + j, sc.nextInt());
					}
				}
			}

			sb = new StringBuilder();
			sb.append("#" + t);

			for (int i = 0; i < 10; i++) {
				sb.append(" " + num.get(i));
			}

			System.out.println(sb);
		}
	}

}
