import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA5677 {

    static class BC implements Comparable<BC> {
        int r, c, coverage, power;

        BC(int r, int c, int coverage, int power) {
            this.r = r;
            this.c = c;
            this.coverage = coverage;
            this.power = power;
        }

        public int compareTo(BC b) {
            return b.power - this.power;
        }
    }

    static int T;
    static int[][] MAP;
    static int M, A; // 이동시간, BC 개수
    static int[] moveA, moveB;
    static BC[] bcInfo;
    static int[] dr = { 0, -1, 0, 1, 0 };
    static int[] dc = { 0, 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            MAP = new int[11][11];

            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            moveA = new int[M];
            moveB = new int[M];
            bcInfo = new BC[A];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                bcInfo[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

        }

    }

    static void solve() {
		int aR = 1, aC = 1;
		int bR = 10, bC = 10;
		int sumA =0, sumB =0;

		for (int i = 0; i < M; i++) {
			aR += dr[moveA[i]];
			aC += dc[moveA[i]];
			bR += dr[moveB[i]];
			bC += dc[moveB[i]];

			List<Integer> aList = isInBC(aR, aC);
			List<Integer> bList = isInBC(bR, bC);
			
			if(aList.size() > 0)
		}
	}

    static List<Integer> isInBC(int r, int c) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            if (Math.abs(r - bcInfo[i].r) + Math.abs(c - bcInfo[i].c) <= bcInfo[i].coverage) {
                list.add(i);
            }
        }

        Collections.sort(list);

        return list;
    }

}
