import java.util.TreeSet;

class Solution {
    static TreeSet<Integer>[] dp;

    public int solution(int N, int number) {
        int answer = -1;
        dp = new TreeSet[9];

        for (int i = 1; i <= 8; i++) {
            makeSet(N, i);

            if (dp[i].contains(number))
                return i;
        }

        return answer;
    }

    static void makeSet(int N, int n) {
        dp[n] = new TreeSet<>();

        int num = 0;
        for (int i = 0; i < n; i++) {
            int pow = 1;
            for (int j = 0; j < i; j++)
                pow *= 10;
            num += N * pow;
        }

        dp[n].add(num);

        for (int i = 1; i < n; i++) {
            int j = n - i;

            for (int a : dp[i]) {
                for (int b : dp[j]) {
                    dp[n].add(a + b);
                    dp[n].add(a - b);
                    dp[n].add(a * b);
                    if (b != 0)
                        dp[n].add(a / b);
                }
            }
        }
    }
}