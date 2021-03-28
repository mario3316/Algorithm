import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1976 {

    static int N, M;
    static int[][] adj;
    static int[] travel;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        adj = new int[N + 1][N + 1];
        travel = new int[M];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            travel[i] = Integer.parseInt(st.nextToken());
        }

        if (solve())
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    static boolean solve() {
        boolean flag = true;
        makeSet();
        connect();

        for (int i = 0; i < M - 1; i++) {
            if (!isConnected(travel[i], travel[i + 1])) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    static void connect() {
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) { // 인접그래프 대칭
                if (adj[i][j] == 1) {
                    union(i, j);
                }
            }
        }
    }

    static void makeSet() {
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;
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

        if (x != y) {
            parent[x] = y;
        }
    }

    static boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

}
