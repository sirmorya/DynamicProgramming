package DynamicProgramming;

public class CoinChange {
	
	static int S[] = { 1, 2, 3};
	
	int countMinChange(int m, int n){
		
		if(n == 0)
			return 1;
		
		if( n < 0 )
			return 0;
		
		if ( m <= 0 && n > 0)
			return 0;
		
		return countMinChange(m, n - S[m -1]) + countMinChange(m - 1, n);
	}
	
	
	/**
	 * This method is used to return the ways of obtaining the change based on
	 * the process of Dynamic Programming.
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	int countDPChange(int m, int n){
		
		int tab[][] = new int[n + 1][m];
		
		int x, y;
		
		//Storing the values if the total count has to be 0 
		for(int i = 0; i < m; i++)
			tab[0][i] = 1;
		
		
		for(int i = 1; i < n+1; i++){
			
			for(int j = 0; j < m; j++){
				
				//Including the S[j] element; i.e. it's equivalent to considering the count of n - S[j] from S[0 ...j]
				x = (i - S[j] >= 0)? tab[i - S[j]][j] : 0;
				
				//Excluding the S[j] element
				y = (j > 0) ? tab[i][j -1] : 0;
				
				tab[i][j] = x + y;
				
			}
		}
		return tab[n][m - 1];
	}
	
	
	public static void main(String[] args) {
		System.out.println(new CoinChange().countMinChange(S.length, 5));
		System.out.println(new CoinChange().countDPChange(S.length, 5));
		
	}
}
