import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17086 {

    static class Shark {
        int r, c;

        Shark(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static int[][] MAP;
    static ArrayList<Shark> list = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAP = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());

                if (MAP[i][j] == 1) {
                    list.add(new Shark(i, j));
                    MAP[i][j] = -1;
                }
            }
        }

        solve();
        System.out.println(max);
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (MAP[i][j] == 0) {
                    int dist = findClosestShark(i, j);
                    max = Math.max(max, dist);
                }
            }
        }
    }

    static int findClosestShark(int r, int c) {
        int min = Integer.MAX_VALUE;

        for (Shark s : list) {
            min = Math.min(min, Math.max(Math.abs(s.r - r), Math.abs(s.c - c)));
        }

        return min;
    }
}
