public class StringPractice {

	public static void main(String[] args) {

		String str = "Hello World!";
		char[] charArr = str.toCharArray();
		System.out.println(charArr[0]); // String to char Array

		String str2 = new String(charArr);
		System.out.println(str2); // char Array to String #1 ( new String )

		StringBuilder sb = new StringBuilder();
		for (char c : charArr)
			sb.append(c);
		String str3 = sb.toString();
		System.out.println(str3); // char Array to String #2 ( StringBuilder )

		char[] charArr2 = new char[charArr.length];
		System.arraycopy(charArr, 0, charArr2, 0, charArr.length);
		for (int i = 0; i < charArr2.length; i++) {
			System.out.println(charArr2[i]);
		} // Array Copy ( Deep Copy )
		System.out.println();

		System.out.println(str == str2); // 서로 다른 객체기 때문에 == 은 false 출력
		System.out.println(str.equals(str2)); // 객체의 내용이 같으면 true 출력

		String[] concat = { "A", "B", "C", "D" };
		String res1 = "";
		for (int i = 0; i < concat.length; i++) {
			res1 += concat[i];
		}
		System.out.println(res1); // Concatenation #1

		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < concat.length; i++) {
			sb2.append(concat[i]);
		}
		System.out.println(sb2.toString()); // Concatenation #2
	}

}
