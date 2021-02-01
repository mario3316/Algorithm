import java.io.BufferedReader;
import java.io.InputStreamReader;

public class samsung_1289 {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			System.out.printf("#%d %d\n", i, solve(str));
		}
	}

	public static int solve(String str) {
		int flag = 0;
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			if (Character.getNumericValue(str.charAt(i)) != flag) {
				cnt++;
				if (flag == 0) {
					flag = 1;
				} else {
					flag = 0;
				}
			}
		}

		return cnt;
	}

}
