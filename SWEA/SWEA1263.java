import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1263 {

    static int T, N;
    static int[][] Cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Cost = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Cost[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int result = Dijkstra(i);
                min = Math.min(min, result);
            }

            System.out.printf("#%d %d\n", t, min);
        }
    }

    static int Dijkstra(int start) {
        int[] dist = new int[N];
        boolean[] visited = new boolean[N];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;

            for (int j = 0; j < N; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && Cost[minIndex][j] > 0) {
                    dist[j] = Math.min(dist[j], min + Cost[minIndex][j]);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += dist[i];

        return sum;
    }

}
