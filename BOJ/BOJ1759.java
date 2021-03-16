import java.util.Arrays;
import java.util.Scanner;

public class BOJ1759 {

    static int L, C;
    static char[] input;
    static char[] output;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        input = new char[C];
        output = new char[L];
        visited = new boolean[C];

        for (int i = 0; i < C; i++) {
            input[i] = sc.next().charAt(0);
        }

        Arrays.sort(input);

        comb(0, 0);
    }

    static void comb(int cnt, int start) {
        if (cnt == L) {
            if (validate()) {
                System.out.println(new String(output));
            }
            return;
        } else {
            for (int i = start; i < C; i++) {
                output[cnt] = input[i];
                comb(cnt + 1, i + 1);
            }
        }
    }

    static boolean validate() {
        int ja = 0;
        int mo = 0;

        for (int i = 0; i < L; i++) {
            if (output[i] == 'a' || output[i] == 'e' || output[i] == 'i' || output[i] == 'o' || output[i] == 'u')
                mo++;
            else
                ja++;
        }

        if (ja >= 2 && mo >= 1)
            return true;
        else
            return false;
    }
}
