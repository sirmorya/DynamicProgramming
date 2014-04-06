
/**
 * This method is used to find the subset of an array which sums up to a certain number.
 * 
 * @author ankit
 *
 */
public class SubsetSum {

	public static void main(String[] args) {
		
		int set[] = {3, 34, 4, 12, 5, 2};
		System.out.println(isSubsetSum(9, set));
		System.out.print("Using Naive recursive method : ");
		System.out.println(recurIsSubsetSum(9,6,set));
	}
	
	
	/**
	 * This is the naive recursive approach.
	 * @param sum
	 * @param n
	 * @param a
	 * @return
	 */
	static boolean recurIsSubsetSum(int sum, int n, int a[]){
		if(sum == 0)
			return true;
		if(n == 0)
			return false;
		// If last element is greater than sum, then ignore it
		if(a[n-1] > sum)
			return recurIsSubsetSum(sum, n-1, a);
		
		 /* else, check if sum can be obtained by any of the following
	      (a) including the last element
	      (b) excluding the last element   */
	   return recurIsSubsetSum(sum, n-1,a) || recurIsSubsetSum( sum-a[n-1], n-1,a);
	}
	
	
	/**
	 * This is a dynamic programming based solution
	 * @param sum
	 * @param a
	 * @return
	 */
	static boolean isSubsetSum(int sum, int a[]){
		
		int  n = a.length;
		//the table subset[i][j] implies that the sum of a[0...j] = i
		boolean subsetSum[][] = new boolean[sum+1][n+1];
		
		//if sum =0, then the subset exist
		for(int i=0; i <= n; i++)
			subsetSum[0][i] = true;
		
		//if sum is not 0 and the number of elements =0 then the subset doesn't exist
		for(int i=1; i <= sum; i++)
			subsetSum[i][0] = false;
		
		for(int i = 1; i <= sum; i++){
			
			for(int j =1; j<= n; j++){
				subsetSum[i][j] = subsetSum[i][j-1];
				if(i >= a[j-1]){
					//Here we check the sum including the last element and excluding the last element similar to the naive recursion process
					// In the statement below the first part of the OR operation checks the sum including the last element
					// the second part checks the sum excluding the last element
					subsetSum[i][j] = subsetSum[i][j] || subsetSum[i - a[j-1]][j-1];
				}
			}
		}
		return subsetSum[sum][n];
	}
}
