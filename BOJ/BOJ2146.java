import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2146 {

    static int N;
    static int[][] MAP;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        MAP = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve());
    }

    static int solve() {
        makeIsland();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (MAP[i][j] > 0 && isBoundary(i, j)) {
                    int dist = findIsland(i, j);

                    if (dist > 0)
                        min = Math.min(min, dist);
                }
            }
        }

        return min;
    }

    static void makeIsland() {
        int num = 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (MAP[i][j] == 1) {
                    MAP[i][j] = num;
                    BFS(i, j, num);
                    num++;
                }
            }
        }
    }

    static boolean isBoundary(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && MAP[nr][nc] == 0)
                return true;
        }
        return false;
    }

    static void BFS(int r, int c, int num) {
        Queue<int[]> Q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        Q.add(new int[] { r, c });
        visited[r][c] = true;

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (isIn(nr, nc) && !visited[nr][nc] && MAP[nr][nc] == 1) {
                    Q.add(new int[] { nr, nc });
                    MAP[nr][nc] = num;
                    visited[nr][nc] = true;
                }
            }
        }
    }

    static int findIsland(int r, int c) {
        Queue<int[]> Q = new LinkedList<>();
        int[][] visited = new int[N][N];

        Q.add(new int[] { r, c });
        visited[r][c] = 1;

        int temp = MAP[r][c];

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (isIn(nr, nc) && visited[nr][nc] == 0 && MAP[nr][nc] != temp) {
                    Q.add(new int[] { nr, nc });
                    visited[nr][nc] = visited[cur[0]][cur[1]] + 1;

                    if (MAP[nr][nc] > 0) {
                        return visited[nr][nc] - 2;
                    }
                }
            }
        }

        return 0;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

}
