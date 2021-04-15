import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953 {

    static int T, N, M, R, C, L;
    static int[][] MAP;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            answer = 0;

            MAP = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    MAP[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            BFS();

            if (L == 1)
                answer = 1;

            System.out.printf("#%d %d\n", t, answer);
        }
    }

    static void BFS() {
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[] { R, C });
        visited[R][C] = true;
        answer++;

        int depth = 1;
        while (!Q.isEmpty()) {
            int size = Q.size();

            while (size > 0) {
                int[] current = Q.poll();
                int r = current[0];
                int c = current[1];

                ArrayList<Integer> dir = getDir(MAP[r][c]);
                for (int i : dir) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (isIn(nr, nc) && !visited[nr][nc] && MAP[nr][nc] > 0) {
                        if (i == 0 && (MAP[nr][nc] == 3 || MAP[nr][nc] == 4 || MAP[nr][nc] == 7))
                            continue;
                        else if (i == 1 && (MAP[nr][nc] == 3 || MAP[nr][nc] == 5 || MAP[nr][nc] == 6))
                            continue;
                        else if (i == 2 && (MAP[nr][nc] == 2 || MAP[nr][nc] == 6 || MAP[nr][nc] == 7))
                            continue;
                        else if (i == 3 && (MAP[nr][nc] == 2 || MAP[nr][nc] == 4 || MAP[nr][nc] == 5))
                            continue;

                        Q.add(new int[] { nr, nc });
                        visited[nr][nc] = true;
                        answer++;
                    }
                }
                size--;
            }
            depth++;
            if (depth >= L)
                break;
        }
    }

    static ArrayList<Integer> getDir(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        switch (n) {
        case 1:
            for (int i = 0; i < 4; i++)
                list.add(i);
            break;
        case 2:
            list.add(0);
            list.add(1);
            break;
        case 3:
            list.add(2);
            list.add(3);
            break;
        case 4:
            list.add(0);
            list.add(3);
            break;
        case 5:
            list.add(1);
            list.add(3);
            break;
        case 6:
            list.add(1);
            list.add(2);
            break;
        case 7:
            list.add(0);
            list.add(2);
            break;
        }

        return list;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
