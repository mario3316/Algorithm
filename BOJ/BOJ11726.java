import java.util.Scanner;

public class BOJ11726 {

	public static int bottomUp (int n) {
        d[0] = 1;
        if (n > 0) d[1] = 1;
        for (int i=2; i<=n; i++) {
            d[i] = d[i-2] + d[i-1];
            d[i] %= 10007; // 이 부분도 마찬가지
        }
        System.out.println(d[n]);
        

}