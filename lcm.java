package lab1;

public class lcm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "abcd";
		String y = "axbycz";
		int n1 = x.length(),n2 = y.length();
		
		int[][] dp = new int[n1+1][n2+1];
		
		for(int i=0;i<=n1;i++) {
			for(int j = 0;j<=n2;j++) {
				if(i==0 || j == 0) {
					dp[i][j] = 0;
				}
				else if(x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Integer.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[n1][n2]);
		
		int len =dp[n1][n2];
		char[] ch = new char[3];
		int i = n1,j = n2;
		while(i>0 && j>0) {
			if(x.charAt(i-1) == y.charAt(j-1)) {
				len--;
				ch[len] = x.charAt(i-1);
				i--;
				j--;
			}
			else if(dp[i-1][j] > dp[i][j-1]) {
				i--;
			}
			else {
				j--;
			}
			
		}
		
		for(int k = 0;k<dp[n1][n2];k++) {
			System.out.print(ch[k]);
		}

	}

}
