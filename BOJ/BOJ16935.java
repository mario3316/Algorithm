import java.util.Scanner;

public class BOJ16935 {

	static int N, M, R;
	static int[][] MAP;
	static int rLen, cLen;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		MAP = new int[N][M];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				MAP[i][j] = sc.nextInt();

		for (int i = 0; i < R; i++) {
			int command = sc.nextInt();

			switch (command) {
			case 1:
				op1();
				break;
			case 2:
				op2();
				break;
			case 3:
				op3();
				break;
			case 4:
				op4();
				break;
			case 5:
				op5();
				break;
			case 6:
				op6();
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(MAP[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void swap() {
		int temp = N;
		N = M;
		M = temp;
	}

	static void op1() { // 상하 반전
		int[][] temp = new int[N][M];

		for (int i = 0; i < N; i++) {
			temp[N - 1 - i] = MAP[i].clone();
		}

		MAP = temp;
	}

	static void op2() { // 좌우 반전
		int[][] temp = new int[N][M];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temp[j][M - i - 1] = MAP[j][i];
			}
		}
		MAP = temp;
	}

	static void op3() { // 오른쪽 90도
		int[][] temp = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[j][N - 1 - i] = MAP[i][j];
			}
		}
		swap();
		MAP = temp;
	}

	static void op4() { // 왼쪽 90도
		int[][] temp = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[M - 1 - j][i] = MAP[i][j];
			}
		}
		swap();
		MAP = temp;
	}

	static void op5() {
		int[][] temp = new int[N][M];

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i][j + M / 2] = MAP[i][j];
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i + N / 2][j] = MAP[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i][j - M / 2] = MAP[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i - N / 2][j] = MAP[i][j];
			}
		}
		MAP = temp;
	}

	static void op6() {
		int[][] temp = new int[N][M];

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i + N / 2][j] = MAP[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i][j + M / 2] = MAP[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i - N / 2][j] = MAP[i][j];
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i][j - M / 2] = MAP[i][j];
			}
		}
		MAP = temp;
	}

}
