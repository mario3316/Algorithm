import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1753 {

    static class Node {
        int v, w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int V, E, K;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Node>[] G;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        visited = new boolean[V + 1];
        G = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            G[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            G[u].add(new Node(v, w));
        }

        Dijkstra();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }

    static void Dijkstra() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        // 시작 노드 초기화

        // 시작노드와 연결되어 있는 노드들 까지의 거리 update
        for (Node n : G[K]) {
            if (!visited[n.v]) {
                dist[n.v] = n.w;
            }
        }

        for (int i = 1; i <= V; i++) {
            int cur = 1;
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= V; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    cur = j;
                }
            }
            // 방문하지 않은 노드들중 dist 가 최소인 것의 dist 와 인덱스를 구함

            visited[cur] = true;
            for (Node n : G[cur]) {
                if (!visited[n.v]) {
                    dist[n.v] = Math.min(dist[n.v], dist[cur] + n.w);
                }
            }
            // 기존 dist 보다 cur를 경유해서 가는게 더 빠르면 dist를 업데이트
        }

    }

}
