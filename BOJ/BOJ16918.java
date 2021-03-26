import java.util.Arrays;
import java.util.Scanner;

public class BOJ16918 {
    static int R, C, N, sec = 2;
    static char[][] MAP;
    static int[][] Time;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        N = sc.nextInt();
        MAP = new char[R][C];
        Time = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(Time[i], Integer.MIN_VALUE);
        }

        for (int i = 0; i < R; i++) {
            MAP[i] = sc.next().toCharArray();
            for (int j = 0; j < C; j++) {
                if (MAP[i][j] == 'O')
                    Time[i][j] = 0;
            }
        }

        while (sec != N + 1) { // N초 후 상태이므로 N초 까지는 실행 ( N+1 이되면 종료 )
            if (sec % 2 == 0) // 짝수 초에는 폭탄 설치
                deployBomb();
            else // 홀수 초에는 폭탄 폭발
                explodeBomb();

            sec++;
        }

        for (int i = 0; i < R; i++) {
            System.out.println(new String(MAP[i]));
        }
    }

    static void deployBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (MAP[i][j] == '.') {
                    MAP[i][j] = 'O';
                    Time[i][j] = sec;
                }
            }
        }
    }

    static void explodeBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (Time[i][j] == sec - 3) {
                    MAP[i][j] = '.';
                    Time[i][j] = Integer.MIN_VALUE;

                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (isIn(nr, nc)) {
                            MAP[nr][nc] = '.';
                        }
                    }
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
