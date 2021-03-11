import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1949 {

    static int T, N, K;
    static int[][] MAP;
    static boolean[][] visited;
    static int maxLen = 0, highest = 0;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            MAP = new int[N][N];
            maxLen = 0;
            highest = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    MAP[i][j] = Integer.parseInt(st.nextToken());
                    highest = Math.max(highest, MAP[i][j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (MAP[i][j] == highest) {
                        visited = new boolean[N][N];
                        DFS(true, 1, i, j);
                    }
                }
            }

            System.out.printf("#%d %d\n", t, maxLen);
        }
    }

    static void DFS(boolean flag, int len, int r, int c) {
        visited[r][c] = true;
        // print();

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && !visited[nr][nc]) {
                if (MAP[nr][nc] < MAP[r][c]) { // 나보다 낮으면 바로 감
                    DFS(flag, len + 1, nr, nc);
                } else if (flag) { // 나보다 낮지않고 공사가 가능하면
                    for (int j = 1; j <= K; j++) {
                        if (MAP[nr][nc] - j < MAP[r][c]) { // 공사 후 갈수 있으면
                            flag = false;
                            // System.out.println("공사 ㅇㅇ " + j);
                            MAP[nr][nc] -= j;
                            DFS(flag, len + 1, nr, nc);
                            MAP[nr][nc] += j;
                            flag = true;
                        }
                    }
                } else { // 나보다 낮지도 않고 공사도 불가능하면 못감
                    continue;
                }
            }
        }

        visited[r][c] = false;
        maxLen = Math.max(maxLen, len);
        return;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static void print() {
        System.out.println("==========");
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
        System.out.println("==========");
    }
}
