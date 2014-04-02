/**
 * This class provides both the solutions; i.e. naive recursive and DP based;
 * for the classic Dice throw problem.
 * 
 * @author ankit
 * 
 */
public class DiceThrow {

	public static void main(String[] args) {

		System.out.println(findWays(6, 3, 8));
		System.out.println(dpFindWays(4, 2, 5));
	}

	/**
	 * This method returns the number of ways to obtain a sum of x from n dices
	 * with m faces. However, this causes the overlapping problem where the same
	 * sub-problem is computed multiple number of times.
	 * 
	 * @param m
	 * @param n
	 * @param x
	 * @return
	 */
	static int findWays(int m, int n, int x) {

		if (x < 1)
			return 0;
		if (n == 1)
			return (x <= m) ? 1 : 0;

		int i, numberOfPaths = 0;
		for (i = 1; i <= m; i++) {
			numberOfPaths += findWays(m, n - 1, x - i);
		}
		return numberOfPaths;
	}

	/**
	 * This method is used to find the number of ways to obtain a sum of x from n dices
	 * and m faces. This solution uses dynamic programming to store the solution of sub-problems.
	 * 
	 * @param m
	 * @param n
	 * @param x
	 * @return
	 */
	static int dpFindWays(int m, int n, int x) {

		int table[][] = new int[n + 1][x + 1];
		for (int i = 1; i <= m && i <= x; i++)
			table[1][i] = 1;
		for (int i = 2; i <= n; i++) 
			for (int j = 1; j <= x; j++) 
				for (int k = 1; k <= m && k < j; k++) 
					table[i][j] += table[i - 1][j - k];
				
		return table[n][x];
	}
}
