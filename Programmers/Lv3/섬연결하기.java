import java.util.*;

class Solution {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    static int N;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parents;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        N = n;
        init();

        for (int i = 0; i < costs.length; i++) {
            pq.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            System.out.println("EDGE : " + e.from + " -> " + e.to);

            if (!isConnected(e.from, e.to)) {
                System.out.println("YES");
                answer += e.weight;
                union(e.from, e.to);
            }
        }

        return answer;
    }

    static void init() {
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[x] = y;
        }
    }

    static int find(int x) {
        if (x == parents[x])
            return x;
        else
            return parents[x] = find(parents[x]);
    }

    static boolean isConnected(int x, int y) {
        x = find(x);
        y = find(y);

        return x == y;
    }
}