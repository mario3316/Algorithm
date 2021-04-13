import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA5677 {

    static class BC {
        int r, c, coverage, power;

        BC(int c, int r, int coverage, int power) {
            this.r = r;
            this.c = c;
            this.coverage = coverage;
            this.power = power;
        }
    }

    static int T;
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

            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            moveA = new int[M + 1];
            moveB = new int[M + 1];
            bcInfo = new BC[A];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                bcInfo[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            System.out.printf("#%d %d\n", t, solve());
        }

    }

    static int solve() {
        int aR = 1, aC = 1;
        int bR = 10, bC = 10;
        int sum = 0;

        for (int i = 0; i <= M; i++) {
            aR += dr[moveA[i]];
            aC += dc[moveA[i]];
            bR += dr[moveB[i]];
            bC += dc[moveB[i]];

            List<Integer> aList = isInBC(aR, aC);
            List<Integer> bList = isInBC(bR, bC);

            if (aList.size() == 0) { // A가 사용할수 있는 BC가 없는 경우
                if (bList.size() == 1) {
                    sum += bcInfo[bList.get(0)].power;
                } else if (bList.size() > 1) {
                    int max = 0;

                    for (int bc : bList) {
                        if (bcInfo[bc].power > max) {
                            max = bcInfo[bc].power;
                        }
                    }

                    sum += max;
                }
            } else if (bList.size() == 0) { // B가 사용할수 있는 BC가 없는 경우
                if (aList.size() == 1) {
                    sum += bcInfo[aList.get(0)].power;
                } else if (aList.size() > 1) {
                    int max = 0;

                    for (int bc : aList) {
                        if (bcInfo[bc].power > max) {
                            max = bcInfo[bc].power;
                        }
                    }

                    sum += max;
                }
            } else if (aList.size() > 0 && bList.size() > 0) {
                sum += calcMaxPower(aList, bList);
            }
        }

        return sum;
    }

    static int calcMaxPower(List<Integer> aList, List<Integer> bList) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < aList.size(); i++) {
            int aBC = aList.get(i);

            for (int j = 0; j < bList.size(); j++) {
                int bBC = bList.get(j);

                if (aBC == bBC)
                    max = Math.max(max, bcInfo[aBC].power);
                else
                    max = Math.max(max, bcInfo[aBC].power + bcInfo[bBC].power);
            }
        }

        return max;
    }

    static List<Integer> isInBC(int r, int c) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            if (Math.abs(r - bcInfo[i].r) + Math.abs(c - bcInfo[i].c) <= bcInfo[i].coverage) {
                list.add(i);
            }
        }

        return list;
    }

}
