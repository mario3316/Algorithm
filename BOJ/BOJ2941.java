import java.util.Scanner;

public class BOJ2941 {

	static String[] Croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=",
			"z=" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		int sum = 0;
		int idx = 0;
		int strLen = str.length();

		while (idx < strLen) {
			String two = null;
			String three = null;

			if (idx + 2 <= strLen)
				two = str.substring(idx, idx + 2);
			if (idx + 3 <= strLen)
				three = str.substring(idx, idx + 3);

			if (three != null && isIn(three)) {
				idx += 3;
			} else if (two != null && isIn(two)) {
				idx += 2;
			} else {
				idx++;
			}

			sum++;
		}

		System.out.println(sum);
	}

	static boolean isIn(String str) {
		for (int i = 0; i < 8; i++) {
			if (Croatia[i].equals(str))
				return true;
		}

		return false;
	}

}
