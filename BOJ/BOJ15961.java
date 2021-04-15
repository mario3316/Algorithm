import java.util.Scanner;

public class BOJ2531 {

    static int N, D, K, C;
    static int[] table, visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = sc.nextInt();
        K = sc.nextInt();
        C = sc.nextInt();
        table = new int[N];
        visited = new int[D + 1];

        for (int i = 0; i < N; i++) {
            table[i] = sc.nextInt();
        }

        System.out.println(solve());
    }

    static int solve() {
        int count = 0, max = 0;

        for (int i = 0; i < K; i++) {
            if (visited[table[i]] == 0)
                count++;
            visited[table[i]]++;
        }

        max = count;
        for (int i = 1; i < N; i++) {
            if (max <= count) {
                if (visited[C] == 0)
                    max = count + 1;
                else
                    max = count;
            }

            visited[table[i - 1]]--;
            if (visited[table[i - 1]] == 0)
                count--;

            if (visited[table[(i + K - 1) % N]] == 0)
                count++;
            visited[table[(i + K - 1) % N]]++;
        }

        return max;
    }

}
