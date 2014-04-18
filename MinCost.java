package dp;

/**
 * This class is used to find the minimum distance required to reach a co-ordinate(m,n) from (0,0) in a 2 D matrix
 * @author ankitsirmorya
 *
 */
public class MinCost {
	
	private int ROW = 3;
	private int COL = 3;
	
	public static void main(String[] args) {
		
		int cost[][] = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
		
		System.out.println(new MinCost().minCost(cost, 2, 2));
		
	}
	
	
	int minCost(int a[][], int m, int n){
		
		int dp[][] = new int[ROW][COL];
		
		dp[0][0] = a[0][0];
		
		//filling the values in the first column
		for(int i = 1; i < ROW; i++){
			dp[i][0] = dp[i-1][0] + a[i][0];
		}
		
		//filling the values in the first column
		for(int i = 1; i < COL; i++){
			dp[0][i] = dp[0][i-1] + a[0][i];
		}
		
		//filling the rest of the values
		for(int i = 1; i <= m; i++)
			for(int j = 1; j <= n; j++)
				dp[i][j] = min(dp[i-1][j] , dp[i][j-1], dp[i-1][j-1]) + a[i][j];
		
		//returning the values
		return dp[m][n];
	}
	
	int min(int x, int y, int z){
		if(x < y)
			return x < z ? x : z;
		else
			return y < z ? y : z;
	}

}
