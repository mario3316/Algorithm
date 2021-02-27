import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ137 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            queue.add(new Pair(Integer.parseInt(br.readLine()), i));
        }

        for(int i=0; i<N; i++) {
            int index = queue.poll().index;
            if(index>i) {
                if(max<index-i)
                    max=index-i;
            }
        }

        if(max==Integer.MIN_VALUE)
            System.out.println(1);
        else
            System.out.println(max+1);
    }

    static class Pair implements Comparable<Pair>{
        int num;
        int index;

        public Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Pair pair) {
            if(this.num==pair.num)
                return this.index > pair.index ? 1 : -1;
            else
                return this.num > pair.num ? 1 : -1;
        }
    }
}