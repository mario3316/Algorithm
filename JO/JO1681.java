import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1681 {

    static int N;
    static int[][] cost;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        cost = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(1, 0, 0);
        System.out.println(min);
    }

    static void DFS(int start, int cnt, int totalDist) {
        if (cnt == N - 1) {
            if (cost[start][1] == 0)
                return;
            else {
                min = Math.min(min, totalDist + cost[start][1]);
            }
            return;
        } else {
            if (totalDist > min)
                return;

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && cost[start][i] > 0) {
                    visited[i] = true;
                    DFS(i, cnt + 1, totalDist + cost[start][i]);
                    visited[i] = false;
                }
            }
        }
    }

}
