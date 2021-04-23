import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class гу╫бец╫ц©Д╠щ {

    public static void main(String[] args) {
        System.out.println(solution(6, 4, 6, 2, new int[][] { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 },
                { 5, 1, 24 }, { 4, 6, 50 }, { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } }));
    }

    static class Node implements Comparable<Node> {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }

    static ArrayList<Node>[] G;
    static int[][] dist;
    static int V;

    static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        V = n;
        G = new ArrayList[n + 1];
        dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++)
            G[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int weight = fare[2];

            G[from].add(new Node(to, weight));
            G[to].add(new Node(from, weight));
        }

        Dijkstra(s);
        Dijkstra(a);
        Dijkstra(b);
        for (int i = 1; i <= n; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }

        int direct = dist[s][a] + dist[s][b];
        for (int i = 1; i <= n; i++) {
            if (dist[s][i] == Integer.MAX_VALUE || dist[i][a] == Integer.MAX_VALUE || dist[i][b] == Integer.MAX_VALUE)
                continue;

            int indirect = dist[s][i] + dist[i][a] + dist[i][b];
            answer = Math.min(answer, indirect);
        }
        answer = Math.min(answer, direct);

        return answer;
    }

    static void Dijkstra(int start) {
        PriorityQueue<Node> PQ = new PriorityQueue<>();

        dist[start][start] = 0;
        PQ.add(new Node(start, 0));

        while (!PQ.isEmpty()) {
            Node curNode = PQ.poll();
            int cur = curNode.to;

            for (Node n : G[cur]) {
                if (dist[start][cur] + n.weight < dist[start][n.to]) {
                    dist[n.to][start] = dist[start][cur] + n.weight;
                    dist[start][n.to] = dist[start][cur] + n.weight;
                    PQ.add(new Node(n.to, dist[start][n.to]));
                }
            }
        }
    }
}
