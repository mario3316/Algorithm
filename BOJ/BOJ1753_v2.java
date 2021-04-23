import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753_v2 {

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }

    }

    static int V, E;
    static ArrayList<Node>[] G;
    static int[] Dist;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        G = new ArrayList[V + 1];
        Dist = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            G[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from, to, weight;

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            G[from].add(new Node(to, weight));
        }

        Dijkstra();

        for (int i = 1; i <= V; i++) {
            if (Dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(Dist[i]);
        }

    }

    static void Dijkstra() {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        Arrays.fill(Dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[V + 1];

        Dist[start] = 0;
        PQ.add(new Node(start, 0));

        while (!PQ.isEmpty()) {
            Node curNode = PQ.poll();
            int cur = curNode.to;

            for (Node n : G[cur]) {
                if (!visited[n.to] && Dist[cur] + n.weight < Dist[n.to]) {
                    Dist[n.to] = Dist[cur] + n.weight;
                    PQ.add(new Node(n.to, Dist[n.to]));
                }
            }
        }

    }
}
