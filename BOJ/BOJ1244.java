import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int T;
	static boolean[] Switch;
	static int[][] Student;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Switch = new boolean[N + 1];

		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++) {
			if (Integer.parseInt(st.nextToken()) == 0)
				Switch[i] = false;
			else
				Switch[i] = true;
		}

		T = Integer.parseInt(br.readLine());
		Student = new int[T][2];

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Student[i][0] = Integer.parseInt(st.nextToken());
			Student[i][1] = Integer.parseInt(st.nextToken());
		}

		solve();
		for (int i = 1; i <= N; i++) {
			if (Switch[i])
				System.out.print("1");
			else
				System.out.print("0");

			if (i % 20 == 0)
				System.out.println();
			else if (i != N)
				System.out.print(" ");
		}
	}

	public static void solve() {
		for (int i = 0; i < T; i++) {
			if (Student[i][0] == 1) { // 남학생
				for (int j = 1; j <= N; j++) {
					if (j % Student[i][1] == 0) { // 배수이면 스위치 반대로
						Switch[j] = !Switch[j];
					}
				}
			} else { // 여학생
				int left = -1;
				int right = 1;
				int idx = Student[i][1];
				Switch[idx] = !Switch[idx];

				while ((idx + left >= 1 && idx + right <= N) && Switch[idx + left] == Switch[idx + right]) {
					Switch[idx + left] = !Switch[idx + left];
					Switch[idx + right] = !Switch[idx + right];
					left--;
					right++;
				}
			}
		}
	}

}
