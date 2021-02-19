import java.util.Scanner;

public class Solution_D4_3234_준환이의양팔저울 {

	static int result;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			int N=scann.nextInt();
			int []nums=new int[N];
			
			for (int i = 0; i <N; i++) {
				nums[i]=scann.nextInt();
			}
			//로직
			boolean[] v=new boolean[N];
			result=0;
			chudfs(0,0,0,nums,v);
			//출력
			System.out.println("#"+t+" "+result);
		}
	}
	static void chudfs(int left, int right, int cnt,
			int[] nums, boolean [] v) {
		// 가지치기 
		if(right>left) return ;
		
		if(cnt==nums.length) {
			result++;
			return ;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(v[i]) continue;
			v[i]=true;
			chudfs(left+nums[i],right,cnt+1,nums,v);
			chudfs(left,right+nums[i],cnt+1,nums,v);
			v[i]=false;
		}
		
		
		
	}
}