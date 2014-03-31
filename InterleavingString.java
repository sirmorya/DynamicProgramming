package dp;

/**
 * This class is used to identify the interleaving of strings using dynamic
 * programming. By the use of DP, the estimated time is reduced from O(2^n) to
 * O(mn).
 * 
 * @author ankitsirmorya
 * 
 */
public class InterleavingString {

	public static void main(String[] args) {
		
		System.out.println("XXY-->XXZ-->XXZXXXY : "+isInterLeaved("XXY", "XXZ", "XXZXXXY"));
		System.out.println("XY-->WZ-->WZXY : "+ isInterLeaved("XY" ,"WZ" ,"WZXY"));
		System.out.println("XXY--->XXZ--->XXXXZY : "+ isInterLeaved("XXY", "XXZ", "XXXXZY"));
	}
	
	/**
	 * This method is used to check if c is an interleaving between a and b.
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	static boolean  isInterLeaved(String a, String b, String c){
		
		//Lengths of individual strings.
		int m = a.length();
		int n = b.length();
		
		//Converting to character array for simplification of process
		char[] A =a.toCharArray();
		char[] B =b.toCharArray();
		char[] C =c.toCharArray();
		
		/*
		 * Creating a 2D array such that IM[i][j] will be true if C[0...i+j-1] is an
		 * interleaving between A[0...i-1] and B[0...j-1]
		 */
		boolean IM[][] =  new boolean[m+1][n+1];
		
		/* "c" will be an interleaving of a and b if the sum of lengths of "a" and "b"
		 * matches that of c.
		 */
		if(c.length() != (m+n))
			return false;
		
		
		//Processing all characters of a and b
		for (int i = 0; i <= m; i++) {
			
			for (int j = 0; j <= n; j++) {
				
				//checking for empty string
				if( i==0 && j==0)
					IM[i][j] = true;
				
				//A is empty
				else if( i == 0 && C[j-1] == B[j-1])
					IM[i][j] = IM[i][j-1];
				
				//B is empty
				else if( j ==0 && C[i-1] == A[i-1])
					IM[i][j] = IM[i-1][j];
				
				//Current character of C is equal to the current character of A but isn't equal to current character of B 
				else if ( (j!=0 && i!=0) && C[i+j-1] == A[i-1] && C[i+j-1] != B[j-1])
					IM[i][j] = IM[i-1][j];
				
				//Current character of C is equal to the current character of B but isn't equal to current character of A
				else if ( (j!=0 && i!=0) && C[i+j-1] != A[i-1] && C[i+j-1] == B[j-1]  )
					IM[i][j] = IM[i][j-1];
				
				else if ((j!=0 && i!=0) && C[i+j-1] == B[j-1] && C[i+j-1] == A[i-1])
					IM[i][j] = (IM[i][j-1] || IM[i-1][j]);
			}
			
		}
		
		//returning the final result
		return IM[m][n];
	}
}
