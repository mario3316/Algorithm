import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        ArrayList<Integer>[] edges = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            edges[e[0]].add(e[1]);
            edges[e[1]].add(e[0]);
        } // 그래프 연결

        answer = BFS(1, n, edges);
        return answer;
    }

    static int BFS(int start, int n, ArrayList<Integer>[] edges) {
        int count = 1;
        int max = 1;

        Queue<Integer> Q = new LinkedList<>();
        int[] visited = new int[n + 1];
        Q.add(start);
        visited[start] = 1;

        while (!Q.isEmpty()) {
            int cur = Q.poll();

            for (int next : edges[cur]) {
                if (visited[next] == 0) {
                    Q.add(next);
                    visited[next] = visited[cur] + 1;
                }
            }

            if (visited[cur] > max) {
                max = visited[cur];
                count = 1;
            } else if (visited[cur] == max) {
                count++;
            }
        }

        return count;
    }
}