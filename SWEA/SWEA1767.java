import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem1 {

    static class Core {
        int r, c;
        boolean isConnected = false;

        Core(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int T, N;
    static int[][] MAP;
    static ArrayList<Core> cores;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int coreNum, coreSum, lineSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            MAP = new int[N][N];
            cores = new ArrayList<>();
            coreNum = 0;
            coreSum = 0;
            lineSum = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    MAP[i][j] = Integer.parseInt(st.nextToken());
                    if (MAP[i][j] == 1) {
                        if (!isAtBoundary(i, j)) {
                            cores.add(new Core(i, j));
                            coreNum++;
                        }
                    }
                }
            }

            Recursive(0, 0, 0);

            System.out.printf("#%d %d\n", t, lineSum);
        }
    }

    static void Recursive(int cnt, int core, int line) {
        if (cnt == coreNum) {
            if (core == coreSum) {
                lineSum = Math.min(lineSum, line);
            } else if (core > coreSum) {
                coreSum = core;
                lineSum = line;
            }
            return;
        } else {
            boolean flag = false;

            Core c = cores.get(cnt);

            for (int i = 0; i < 4; i++) {
                if (isConnectable(c.r, c.c, i)) {
                    flag = true;

                    int lineCnt = fill(c.r, c.c, i, 2); // 2가 전선
                    Recursive(cnt + 1, core + 1, line + lineCnt);
                    fill(c.r, c.c, i, 0);
                }
            }

            if (!flag) {
                Recursive(cnt + 1, core, line);
            }
        }
    }

    static int fill(int r, int c, int d, int num) {
        int cnt = 0;

        while (true) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!isIn(nr, nc))
                break;
            else {
                MAP[nr][nc] = num;
                cnt++;
                r = nr;
                c = nc;
            }
        }

        return cnt;
    }

    static boolean isConnectable(int r, int c, int d) {
        while (true) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!isIn(nr, nc))
                break;
            else if (MAP[nr][nc] != 0) {
                return false;
            } else {
                r = nr;
                c = nc;
            }
        }

        return true;
    }

    static boolean isAtBoundary(int r, int c) {
        if (r == 0 || r == N - 1 || c == 0 || c == N - 1)
            return true;
        else
            return false;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

}
