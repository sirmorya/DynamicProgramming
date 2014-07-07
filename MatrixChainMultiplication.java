package DynamicProgramming;

public class MatrixChainMultiplication {

	
	static int p[] = {10, 30, 5, 60};
	
	/**
	 * This is a naive recursive method which is used to count the number of multiplications in a chain of matrixes
	 * 
	 * @param low
	 * @param high
	 * @return
	 */
	int doMatrixchainMultiple(int low, int high){
		
		if(low == high)
			return 0;
		int min = Integer.MAX_VALUE, cost ;
		for(int k = low; k < high; k++){
			cost = doMatrixchainMultiple(low, k) + doMatrixchainMultiple(k + 1, high) +  p[low - 1] * p[k] * p[high];
			if(min > cost)
				min = cost;
		}
		return min;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(new MatrixChainMultiplication().doMatrixchainMultiple(1, p.length - 1));
	}
}
