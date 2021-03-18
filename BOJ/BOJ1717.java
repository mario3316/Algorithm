import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(a, b);
            } else {
                if (isConnected(a, b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    static boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
        // 최종 부모를 찾았으면 거슬러 올라가면서 parent를 모두 최종 부모로 바꿔준다.
        // 그래야 다음에 찾을때 처음부터 내려가면서 찾지않고 depth = 1 만큼만 찾는다.
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y)
            parent[x] = y;
    }

}
