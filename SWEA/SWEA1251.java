import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA1251 {

    static int T, N;
    static double E;
    static double[][] islands;
    static int[] parent;
    static ArrayList<Edge> list;

    static class Edge implements Comparable<Edge> {
        int from, to;
        double weight;

        Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge e) {
            return Double.compare(this.weight, e.weight);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            islands = new double[N][2];

            for (int i = 0; i < N; i++) {
                islands[i][0] = sc.nextDouble();
            }
            for (int i = 0; i < N; i++) {
                islands[i][1] = sc.nextDouble();
            }

            E = sc.nextDouble();

            double L = kruskal();
            double ans = E * L;

            System.out.printf("#%d %.0f\n", t, ans);
        }

    }

    static void makeSet() {
        parent = new int[N];

        for (int i = 0; i < N; i++)
            parent[i] = i;
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[x] = y;
        }
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    static boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    static void makeList() {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                list.add(new Edge(i, j, (islands[i][0] - islands[j][0]) * (islands[i][0] - islands[j][0])
                        + (islands[i][1] - islands[j][1]) * (islands[i][1] - islands[j][1])));
            }
        }
    }

    static double kruskal() {
        double sum = 0;
        list = new ArrayList<>();

        makeSet(); // 사이클 검사를 위한 disjoint set 생성
        makeList(); // 간선 정보 입력

        Collections.sort(list); // 가중치 오름차순으로 정렬

        for (Edge e : list) {
            if (!isConnected(e.from, e.to)) {
                sum += e.weight;
                union(e.from, e.to);
            }
        }

        return sum;
    }

}
