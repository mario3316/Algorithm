import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21609 {

    static class Group implements Comparable<Group> {
        int r, c; // ���� ���
        int size, rainbow;

        Group(int r, int c, int size, int rainbow) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.rainbow = rainbow;
        }

        @Override
        public int compareTo(Group g) {
            if (this.size != g.size) {
                return g.size - this.size;
            } else {
                if (this.rainbow != g.rainbow)
                    return g.rainbow - this.rainbow;
                else {
                    if (this.r != g.r)
                        return g.r - this.r;
                    else
                        return g.c - this.c;
                }
            }
        }
    }

    static int N, M;
    static int[][] MAP;
    static int[] dr = { 1, 0, -1, 0 }; // �� �� �� ��
    static int[] dc = { 0, 1, 0, -1 };
    static PriorityQueue<Group> PQ;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAP = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());

                if (MAP[i][j] == 0)
                    MAP[i][j] = -2; // ����������� -2��
            }
        }

        System.out.println(autoPlay());
    }

    static int autoPlay() {
        int sum = 0;

        while (true) {
            PQ = new PriorityQueue<>();
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] || MAP[i][j] <= 0)
                        continue;

                    BFS(i, j, false);
                    initRainbow();
                }
            }

            if (PQ.size() == 0) // ��� �׷��� ������ ����
                break;

            Group G = PQ.poll();
            sum += G.size * G.size;
            visited = new boolean[N][N];
            BFS(G.r, G.c, true);
            // �ٽ� ���� ��Ϻ��� BFS ������ ����� ����

            gravity();
            rotate();
            gravity();
        }

        return sum;
    }

    static void BFS(int sr, int sc, boolean delete) { // delete = true �̸� BFS��
                                                      // ã���鼭 ��� ����
        Queue<int[]> Q = new LinkedList<>();
        int color = MAP[sr][sc];
        int size = 0, rainbow = 0;

        Q.add(new int[] { sr, sc });
        visited[sr][sc] = true;
        size++;
        if (delete)
            MAP[sr][sc] = 0;

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isIn(nr, nc) && !visited[nr][nc] && (MAP[nr][nc] == color || MAP[nr][nc] == -2)) {

                    Q.add(new int[] { nr, nc });
                    visited[nr][nc] = true;
                    size++;

                    if (MAP[nr][nc] == -2)
                        rainbow++;

                    if (delete)
                        MAP[nr][nc] = 0;
                }
            }
        }

        if (size >= 2) {
            PQ.add(new Group(sr, sc, size, rainbow));
        }
    }

    static void initRainbow() { // ��������� �湮 ����
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (MAP[i][j] == -2 && visited[i][j])
                    visited[i][j] = false;
            }
        }
    }

    static void gravity() { // �Ʒ��� ���� ( �߷� )
        for (int c = 0; c < N; c++) {
            for (int r = N - 2; r >= 0; r--) {
                if (MAP[r][c] == 0 || MAP[r][c] == -1)
                    continue;

                int nr = r;
                while (nr + 1 < N && MAP[nr + 1][c] == 0)
                    nr++;

                if (nr > r) {
                    MAP[nr][c] = MAP[r][c];
                    MAP[r][c] = 0;
                }
            }
        }
    }

    static void rotate() { // �ݽð� 90�� ȸ��
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = MAP[j][N - i - 1];
            }
        }

        MAP = temp;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

}
