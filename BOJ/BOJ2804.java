import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2804 {

	static char[] A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = st.nextToken().toCharArray();
		B = st.nextToken().toCharArray();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (A[i] == B[j]) {
					makeString(i, j);
					return;
				}
			}
		}
	}

	static void makeString(int i, int j) {
		char[][] MAP = new char[B.length][A.length];
		for (int a = 0; a < B.length; a++)
			for (int b = 0; b < A.length; b++)
				MAP[a][b] = '.';

		MAP[j] = A.clone();
		for (int a = 0; a < B.length; a++) {
			MAP[a][i] = B[a];
		}

		for (int a = 0; a < B.length; a++) {
			System.out.println(new String(MAP[a]));
		}
	}
}
