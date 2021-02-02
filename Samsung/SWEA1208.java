import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1208 {

	static int N;
	final static int cLen = 100;
	static int[] rLen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int i = 1; i <= 10; i++) {
			rLen = new int[cLen];
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < cLen; j++) {
				rLen[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < N; j++) {
				dump();
			}
			System.out.printf("#%d %d\n", i, rLen[findMax()] - rLen[findMin()]);
		}
	}

	public static void dump() {
		int maxIndex = findMax();
		int minIndex = findMin();

		rLen[maxIndex]--;
		rLen[minIndex]++;
	}

	public static int findMax() {
		int max = 0;
		int maxIndex = 0;

		for (int i = 0; i < cLen; i++) {
			if (rLen[i] > max) {
				maxIndex = i;
				max = rLen[i];
			}
		}

		return maxIndex;
	}

	public static int findMin() {
		int min = 100;
		int minIndex = 0;

		for (int i = 0; i < cLen; i++) {
			if (rLen[i] < min) {
				minIndex = i;
				min = rLen[i];
			}
		}

		return minIndex;
	}

}
