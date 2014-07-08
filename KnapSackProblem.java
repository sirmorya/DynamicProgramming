package DynamicProgramming;

/*QUESTION :
 Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
 In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights
 associated with n items respectively. Also given an integer W which represents knapsack capacity,
 find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
 You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */


/**
 * This class is used to solve the KnapSack Problem.
 * 
 * @author ankitsirmorya
 *
 */
public class KnapSackProblem {
	
	
	
	/**
	 * @param W := Remaining weight to be calculated
	 * @param wt := Array of weights
	 * @param val := array of values
	 * @param n := number of elements
	 * @return
	 */
	int naiveKnapSackProblem(int W, int[] wt, int[] val, int n){
		
		if(W == 0 || n == 0)
			return 0;
		
		if(wt[n - 1] > W)
			return naiveKnapSackProblem(W, wt, val, n - 1);
		
		return Math.max(val[n -1] + naiveKnapSackProblem(W - wt[n - 1], wt, val, n - 1), naiveKnapSackProblem(W, wt, val, n - 1));
	}
	
	/**
	 * This is a dynamic programming approach to solve the Knapsack problem.
	 * 
	 * @param W
	 * @param w
	 * @param val
	 * @param n
	 * @return
	 */
	int dpKnapSackProblem(int W, int[] w, int[] val, int n){
		
		int calValues[][] = new int[n + 1][W + 1];
		
		for(int i = 0; i <= n; i++){
			
			for (int j = 0; j <= W; j++) {
				if (i == 0 || j == 0)
					calValues[i][j] = 0;
				else if (w[i - 1] <= j)
					calValues[i][j] = Math.max(calValues[i - 1][j - w[i - 1]]
							+ val[i - 1], calValues[i - 1][j]);
				else
					calValues[i][j] = calValues[i - 1][j];
			}
		}
		return calValues[n][W];
	}
	
	
	/**
	 * This method solves the Knapsack problem and returns the indexes of the element which are part of the solution. 
	 * @param W
	 * @param w
	 * @param val
	 * @param n
	 */
	void knapSack(int W, int[] w, int[] val, int n){
		
		int calValues[][] = new int[n + 1][W + 1];
		//An array to check whether to store the flag whether a particular element has to be included.
		boolean keep[][] = new boolean[n + 1][W + 1];
		
		for(int i = 0; i <= n; i++){
			
			for (int j = 0; j <= W; j++) {

				if (i == 0 || j == 0)
					calValues[i][j] = 0;
				else if (w[i - 1] <= j
						&& (val[i - 1] + calValues[i - 1][j - w[i - 1]] > calValues[i - 1][j])) {
					calValues[i][j] = val[i - 1] +  calValues[i - 1][j - w[i - 1]];
					keep[i][j] = true;
				} else
					calValues[i][j] = calValues[i - 1][j];

			}
		}
		System.out.println("The sum is : "+ calValues[n][W]);
		
		int k = W;
		
		for(int i = n; i >= 1; i--){
			if(keep[i][k]){
				System.out.println("Index : "+i +" , Value :"+val[i - 1]);
				k = k - w[i - 1];
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		int[] val= {10,40,30,50};
		int[] wt = {5,4,6,3};
		int W = 10;
		
		//System.out.println(new KnapSackProblem().naiveKnapSackProblem(W, wt, val, val.length));
		//System.out.println(new KnapSackProblem().dpKnapSackProblem(W, wt, val, val.length));
	    new KnapSackProblem().knapSack(W, wt, val, val.length);
		
	}
}

