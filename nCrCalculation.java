package DynamicProgramming;

public class nCrCalculation {

	
	
	/**
	 * This is a naive recursive method to calculate the Binomial Coefficient; i.e. nCr.
	 * @param n
	 * @param k
	 * @return
	 */
	int binomialCoeff(int n, int k){
		
		if(k == 0 || k == n)
			return 1;
		return binomialCoeff(n - 1, k) + binomialCoeff(n - 1, k - 1);
		
	}
	
	/**
	 * This is the dp based solution.
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	int binomialCoeffDp(int n, int k){
		
		int c[]  = new int[k + 1];
		c[0] = 1;
		
		for(int i = 1; i <= n; i++){
			
			for(int j = Math.min(i, k); j > 0; j--){
				c[j] = c[j] + c[j - 1];
			}
		}
		
		return c[k];
	}
	
	public static void main(String[] args) {
		
		nCrCalculation obj = new nCrCalculation();
		System.out.println(obj.binomialCoeff(5, 2));
		System.out.println(obj.binomialCoeffDp(5, 2));
	}
}
