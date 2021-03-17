import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236 {

    static class Fish implements Comparable<Fish> {
        int r, c, size, dist;

        Fish(int r, int c, int size, int dist) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.dist = dist;
        }

        public int compareTo(Fish f) {
            if (this.dist != f.dist) {
                return this.dist - f.dist;
            } else if (this.r != f.r) {
                return this.r - f.r;
            } else
                return this.c - f.c;
        }
    }

    static int N;
    static int[][] MAP;
    static int[][] visited;
    static int sharkR, sharkC, sharkSize;
    static PriorityQueue<Fish> fishQ = new PriorityQueue<>();
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        MAP = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
                if (MAP[i][j] == 9) {
                    sharkR = i;
                    sharkC = j;
                    sharkSize = 2;
                }
            }
        }

        eat();
        System.out.println(answer);
    }

    static void eat() {
        int eatNumber = 0;
        while (true) {
            if (!BFS(sharkR, sharkC))
                break;
            else {
                Fish prey = fishQ.poll();
                MAP[sharkR][sharkC] = 0;
                MAP[prey.r][prey.c] = 0;
                sharkR = prey.r;
                sharkC = prey.c;
                answer += prey.dist;
                eatNumber++;

                if (eatNumber == sharkSize) {
                    sharkSize++;
                    eatNumber = 0;
                }
            }
        }
    }

    static boolean BFS(int r, int c) { // Fish 우선순위 큐 업데이트
        Queue<int[]> Q = new LinkedList<>();
        fishQ.clear();
        visited = new int[N][N];
        boolean flag = false;

        Q.offer(new int[] { r, c });
        visited[r][c] = 1; // 1로 시작했으니까 나중에 1 빼줘야함

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            int cr = cur[0];
            int cc = cur[1];

            // 꺼낸놈이 물고기 이면
            if (MAP[cr][cc] >= 1 && MAP[cr][cc] <= 6) {
                // 먹을수 있으면
                if (MAP[cr][cc] < sharkSize) {
                    fishQ.offer(new Fish(cr, cc, MAP[cr][cc], visited[cr][cc] - 1));
                    flag = true;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (isIn(nr, nc) && visited[nr][nc] == 0 && MAP[nr][nc] <= sharkSize) {
                    Q.offer(new int[] { nr, nc });
                    visited[nr][nc] = visited[cr][cc] + 1;
                }
            }
        }

        // 먹을수 있는 물고기가 한마리라도 있으면 true
        return flag;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

}
