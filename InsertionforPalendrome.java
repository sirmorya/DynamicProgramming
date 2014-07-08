package DynamicProgramming;
/**
 * The minimum number of insertions needed to generate a palendrome.
 * @author ankit
 *
 */
public class InsertionforPalendrome {

	public static void main(String[] args) {
		System.out.println(findMinInsertionsDp("geeks".toCharArray(), 5));
	}
	
	/**
	 * This method is used to return the minimum number of insertions needed to generate a palendrome
	 * using the naive recursive method. This includes the overlapping problem.
	 *  
	 * @param s
	 * @param l
	 * @param h
	 * @return
	 */
	int findMinInsertions(char[] s, int l, int h){
		
		if( l == h) return 0;
		if( l == h-1 ) return s[l] == s[h]? 0 : 1; 
		return s[l] == s[h] ? findMinInsertions(s, l+1, h-1) : min(findMinInsertions(s, l+1, h), findMinInsertions(s, l, h-1))+1;
	}
	
	static int min (int a, int b){
		return a < b ? a : b;
	}
	
	/**
	 * This method solves the same problem uses dp. It starts with sub-problems having length =2 and goes on.
	 * The solution for smaller sub-problems are used to solve larger problems.
	 * @param s
	 * @param n
	 * @return
	 */
	static int findMinInsertionsDp(char[] s, int n){
		
		int table[][] = new int[n][n];
		
		for(int gap = 1;gap < n; gap++)
			for(int l = 0, h = gap; h < n; h++, l++)
				table[l][h] = (s[l] == s[h])? table[l+1][h-1] : min (table[l][h-1],table[l+1][h])+1;
		return table[0][n-1];
	}
	
	
}
