import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 순위 {

    static ArrayList<Integer>[] edges;
    static int[][] result;

    public static void main(String[] args) {
        순위 s = new 순위();
        s.solution(5, new int[][] { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } });
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        edges = new ArrayList[n + 1];
        result = new int[n + 1][n + 1];

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
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (result[i][j] != 0)
                    count++;
            }

            if (count == n - 1)
                answer++;

            System.out.println(Arrays.toString(result[i]));
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
                    result[next][start] = -1;
                    result[start][next] = 1;
                }
            }
        }
    }
}
