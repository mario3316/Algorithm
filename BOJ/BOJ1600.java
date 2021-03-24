import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600 {

    static int K, W, H;
    static int[][] MAP;
    static int[][][] visited;
    static int dr[] = { -1, 1, 0, 0 };
    static int hr[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int dc[] = { 0, 0, -1, 1 };
    static int hc[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        MAP = new int[H][W];
        visited = new int[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(0, 0);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            if (visited[H - 1][W - 1][i] != 0 && visited[H - 1][W - 1][i] < min) {
                min = visited[H - 1][W - 1][i];
            }
        }

        if (min == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(min - 1);
    }

    static void BFS(int r, int c) {
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[] { r, c });
        visited[r][c][0] = 1;

        while (!Q.isEmpty()) {
            int[] current = Q.poll();

            for (int k = 0; k <= K; k++) {
                if (visited[current[0]][current[1]][k] > 0) {

                    for (int i = 0; i < 8; i++) {
                        int nr = current[0] + hr[i];
                        int nc = current[1] + hc[i];

                        if (isIn(nr, nc) && MAP[nr][nc] == 0 && k < K && visited[nr][nc][k + 1] == 0) {
                            visited[nr][nc][k + 1] = visited[current[0]][current[1]][k] + 1;
                            Q.add(new int[] { nr, nc });
                        }
                    }

                    for (int i = 0; i < 4; i++) {
                        int nr = current[0] + dr[i];
                        int nc = current[1] + dc[i];

                        if (isIn(nr, nc) && MAP[nr][nc] == 0 && visited[nr][nc][k] == 0) {
                            visited[nr][nc][k] = visited[current[0]][current[1]][k] + 1;
                            Q.add(new int[] { nr, nc });
                        }
                    }
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < H && c >= 0 && c < W;
    }

}
