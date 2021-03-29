import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ1755 {

    static String[] strArr = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    static String[] sorted = { "eight", "five", "four", "nine", "one", "seven", "six", "three", "two", "zero" };

    static class Number implements Comparable<Number> {
        int num;
        String[] str; // 각 자리수 별로 끊어서 해당 수에 맞는 STring을 저장하는 배열

        Number(int num) {
            this.num = num;

            String s = Integer.toString(num);
            str = new String[s.length()];

            for (int i = 0; i < s.length(); i++) {
                str[i] = findString(Character.toString(s.charAt(i)));
            }
        }

        // 해당 숫자에 맞는 String을 strArr에서 찾아주는 함수
        public String findString(String num) {
            int d = Integer.parseInt(num);
            return strArr[d];
        }

        // 각 자리수 별로 String의 사전 순을 비교하기 위해 sorted 배열의 Index를 리턴
        public int findIndex(String str) {
            for (int i = 0; i < 10; i++) {
                if (sorted[i].equals(str))
                    return i;
            }

            return 0;
        }

        public int compareTo(Number n) {
            int thisidx = this.str.length;
            int nidx = n.str.length;

            int i = 0;
            while (i < thisidx && i < nidx) {
                int a = findIndex(this.str[i]);
                int b = findIndex(n.str[i]);
                // 각 자리수의 index를 찾아옴

                if (a != b) { // 첫 자리수부터 다르면 더 작은 Index가 앞으로 가게 오름차순 정렬
                    return a - b;
                } else {
                    i++;

                    // 두 숫자의 자리수가 다를수 있기때문에 자리수가 더 작은 수를 앞으로오도록 정렬
                    if (i == nidx) {
                        return 1;
                    } else if (i == thisidx) {
                        return -1;
                    } else
                        continue;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();

        ArrayList<Number> list = new ArrayList<>();

        for (int i = from; i <= to; i++) {
            list.add(new Number(i));
        } // from과 to 사이의 모든 숫자들을 우선순위 큐에 삽입

        Collections.sort(list);

        for (int i = 1; i <= list.size(); i++) {
            if (i % 10 == 0)
                System.out.println(list.get(i - 1).num);
            else
                System.out.print(list.get(i - 1).num + " ");
        }
    }

}
