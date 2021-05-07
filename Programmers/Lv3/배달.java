import java.util.*;

class Solution {

    static class Node implements Comparable<Node> {
        int end, cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    static int num;
    static List<Node>[] MAP;
    static int[] dist;
    static boolean[] visited;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        num = N;

        MAP = new ArrayList[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            MAP[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < road.length; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];

            MAP[from].add(new Node(to, cost));
            MAP[to].add(new Node(from, cost));
        }

        Dijkstra(1);

        System.out.println(Arrays.toString(dist));

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K)
                answer++;
        }

        return answer;
    }

    static void Dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.end])
                continue;
            else
                visited[cur.end] = true;

            for (Node n : MAP[cur.end]) {
                if (!visited[n.end] && dist[n.end] > dist[cur.end] + n.cost) {
                    dist[n.end] = dist[cur.end] + n.cost;
                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }
    }
}