import java.util.Arrays;
import java.util.Scanner;

public class BOJ1931 {

	static class Meeting implements Comparable<Meeting> {
		int start, end;

		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Meeting o) {
			if (this.end == o.end)
				return this.start - o.start;
			else
				return this.end - o.end;
		}// 끝나는 시간 오름차순 정렬 (끝나는 시간이 같으면 시작 시간 오름차순 )

	}

	static int N;
	static Meeting[] schedule;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		schedule = new Meeting[N];

		for (int i = 0; i < N; i++) {
			schedule[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}

		System.out.println(count());
	}

	static int count() {
		int cnt = 1; // 하나를 넣고 시작하므로 1부터 시작
		Arrays.sort(schedule);

		Meeting current = schedule[0];

		for (int i = 1; i < N; i++) {
			if (schedule[i].start >= current.end) {
				cnt++;
				current = schedule[i];
				// current 갱신
			}
		}

		return cnt;
	}
}
