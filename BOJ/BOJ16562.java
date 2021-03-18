import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16562 {

    static int N, M, K;
    static int[] parent;
    static int[] cost;
    static PriorityQueue<Cost> Q = new PriorityQueue<>();
    static int answer = 0;

    static class Cost implements Comparable<Cost> {
        int num, c;

        Cost(int num) {
            this.num = num;
            this.c = cost[find(num)];
        }

        public int compareTo(Cost next) {
            return this.c - next.c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        makeSet();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        while (solve() > 1 && answer <= K) {
            Cost a = Q.poll();
            Cost b = Q.poll();

            union(a.num, b.num);
            answer += a.c + b.c;
        }

        if (answer > K)
            System.out.println("Oh no");
        else
            System.out.println(answer);
    }

    static int solve() {
        boolean[] visited = new boolean[N + 1];
        Q.clear();

        for (int i = 0; i <= N; i++) {
            int p = find(i);
            if (!visited[p]) {
                Q.offer(new Cost(p));
                visited[p] = true;
            }
        }

        return Q.size();
    }

    static void makeSet() {
        parent = new int[N + 1];
        cost = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return;
        else {
            if (cost[x] >= cost[y])
                parent[x] = y;
            else
                parent[y] = x;
        }
    }

}
