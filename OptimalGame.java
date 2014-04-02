
public class OptimalGame {

	public static void main(String[] args) {
		int arr1[] = {8, 15, 3, 7};
		System.out.println(new OptimalGame().optimalStrategyOfGame(arr1));
	}
	
	int max(int a, int b){
		return a>b ? a : b;
	}
	
	int min(int a, int b){
		return a<b ? a : b;
	}
	
	int optimalStrategyOfGame(int[] arr){
		int n = arr.length,x,y,z;
		int table[][] = new int[n][n];
		
		for(int gap =0 ; gap < n; gap++){
			
			for(int i=0, j = gap; j < n ; j++,i++){
				
				x = ((i+2) <= j) ? table[i+2][j]:0;
				y = ((i+1) <= (j-1)) ? table[i+1][j-2] : 0;
				z = ( i <= (j-2)) ? table[i][j-2] : 0;
				
				table[i][j] = max( arr[i]+ min(x,y), arr[j] + min(y,z));
			}
		}
		return table[0][n-1];
	}
}
