import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ¼øÀ§ {

    static ArrayList<Integer>[] edges;
    static int[] count;

    public int solution(int n, int[][] results) {
        int answer = 0;
        edges = new ArrayList[n + 1];
        count = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int[] r : results) {
            edges[r[0]].add(r[1]);
        }

        for (int i = 1; i <= n; i++) {
            BFS(i, n);
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] >= n - 1)
                answer++;
        }

        return answer;
    }

    static void BFS(int start, int n) {
        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        Q.add(start);
        visited[start] = true;

        while (!Q.isEmpty()) {
            int cur = Q.poll();

            for (int next : edges[cur]) {
                if (!visited[next]) {
                    Q.add(next);
                    visited[next] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                count[i]++;
            }
        }
    }
}
