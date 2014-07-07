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
	
	
	/**
	 * This method is used to solve the matrix chain multiplication problem using DP
	 * @param low
	 * @param high
	 * @return
	 */
	int doDPMatrixChainMultiple(int low, int high){
		
		int m[][] = new int[high ][high];

		// Here the value of m[i][j] is the number of matrix multiplications
		// which will be done from A[i]...A[j]. 
		int j, cost;
		for(int L = 2; L < high; L++){
			
			for(int i = 1; i < high - L +1; i++){
				j = i + L - 1;
				m[i][j] = Integer.MAX_VALUE;
				for(int k = i; k < j && k < high - 1; k++){
					cost= m[i][k] + m[k+1][j] + p[i - 1] * p[k] * p[j];
					if(cost < m[i][j])
						m[i][j] = cost;
				}
			}
		}
		return m[1][high - 1];
	}
	
	public static void main(String[] args) {
		
		//System.out.println(new MatrixChainMultiplication().doMatrixchainMultiple(1, p.length - 1));
		System.out.println(new MatrixChainMultiplication().doDPMatrixChainMultiple(1, p.length));
	}
}
