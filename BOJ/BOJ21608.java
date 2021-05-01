import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ21608 {

    static class Space implements Comparable<Space> {
        int f, e, r, c;

        Space(int f, int e, int r, int c) {
            this.f = f;
            this.e = e;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Space s) {
            if (this.f != s.f) {
                return s.f - this.f;
            } else {
                if (this.e != s.e)
                    return s.e - this.e;
                else {
                    if (this.r != s.r)
                        return this.r - s.r;
                    else
                        return this.c - s.c;
                }
            }
        }

    }

    static int N;
    static int[][] MAP;
    static ArrayList<Integer>[] Friend;
    static int[] Point;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int[] satisfaction = { 0, 1, 10, 100, 1000 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        MAP = new int[N][N];
        Friend = new ArrayList[N * N + 1];
        for (int i = 1; i <= N * N; i++)
            Friend[i] = new ArrayList<>();
        Point = new int[N * N + 1];

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 4; j++)
                Friend[idx].add(Integer.parseInt(st.nextToken()));

            solve(idx);
        }

        calcPoint();
        int sum = 0;
        for (int i = 1; i <= N * N; i++) {
            sum += Point[i];
        }

        System.out.println(sum);
    }

    static void solve(int idx) {
        PriorityQueue<Space> PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (MAP[i][j] != 0)
                    continue;

                PQ.add(new Space(scanFriend(i, j, idx), scanEmpty(i, j), i, j));
            }
        }

        Space result = PQ.poll();
        MAP[result.r][result.c] = idx;
    }

    static void calcPoint() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                int idx = MAP[i][j];
                Point[idx] += satisfaction[scanFriend(i, j, idx)];
            }
        }
    }

    static int scanFriend(int r, int c, int idx) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!isIn(nr, nc))
                continue;

            if (Friend[idx].contains(MAP[nr][nc]))
                cnt++;
        }

        return cnt;
    }

    static int scanEmpty(int r, int c) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!isIn(nr, nc))
                continue;

            if (MAP[nr][nc] == 0)
                cnt++;
        }

        return cnt;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

}
