import java.util.Scanner;

public class BOJ2477 {
	static int N;
	static int[][] len = new int[6][2];
	static int bigX = 0, bigY = 0, smallX = 0, smallY = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < 6; i++) {
			len[i][0] = sc.nextInt();
			len[i][1] = sc.nextInt();

			if (len[i][0] == 1)
				bigX += len[i][1];
			if (len[i][0] == 4)
				bigY += len[i][1];
		}

		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				if (len[5][1] + len[i + 1][1] == bigX)
					smallY = len[i][1];
				if (len[5][1] + len[i + 1][1] == bigY)
					smallX = len[i][1];
			} else if (i == 5) {
				if (len[i - 1][1] + len[0][1] == bigX)
					smallY = len[i][1];
				if (len[i - 1][1] + len[0][1] == bigY)
					smallX = len[i][1];
			} else {
				if (len[i - 1][1] + len[i + 1][1] == bigX)
					smallY = len[i][1];
				if (len[i - 1][1] + len[i + 1][1] == bigY)
					smallX = len[i][1];
			}
		}

		System.out.println((bigX * bigY - smallX * smallY) * N);
	}

}
