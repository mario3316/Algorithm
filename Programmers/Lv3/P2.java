import java.util.ArrayList;
import java.util.Arrays;

public class P2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(9,
                new int[][] { { 0, 2 }, { 2, 1 }, { 2, 4 }, { 3, 5 }, { 5, 4 }, { 5, 7 }, { 7, 6 }, { 6, 8 } })));
    }

    static class Node {
        int num;
        ArrayList<Node> child;

        Node(int num) {
            this.num = num;
            child = new ArrayList<>();
        }
    }

    static int[] solution(int n, int[][] edges) {
        int[] result = new int[2];

        Node[] tree = new Node[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new Node(i);
        }

        boolean[] check = new boolean[n - 1];
        int count = 0;
        while (count)

            return result;
    }
}
