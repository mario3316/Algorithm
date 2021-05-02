import java.util.Scanner;

public class BOJ2846 {

    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int max = 0;
        int cnt = 0;

        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i - 1]) {
                cnt += arr[i] - arr[i - 1];
                max = Math.max(max, cnt);
            } else
                cnt = 0;
        }

        System.out.println(max);

    }

}
