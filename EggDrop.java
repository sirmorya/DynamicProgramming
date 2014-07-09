package DynamicProgramming;


/*  QUESTION
 * ----------
 * 
 * Egg dropping puzzle
 * 
 *  APPROACH
 *  ---------
 * 1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs
 2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x; so the problem reduces to k-x floors and n eggs.

 Since we need to minimize the number of trials in worst case, we take the maximum of two cases. We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.
 */


public class EggDrop {
	
	/**
	 * Naive Approach
	 * @param n
	 * @param k
	 * @return
	 */
	int eggDrop(int n, int k){
		
		//If there are no floors then no trial is needed and if there is one floor 
		//then one trial is needed
		if(k == 0 || k == 1)
			return 1;
		
		//if there is one egg then k trials will
		if(n == 1)
			return k;
		
		int min = Integer.MAX_VALUE, res;
		
		for(int x = 1; x <= k; x++){
			
			res =  Math.max(eggDrop(n - 1, x - 1)//If the egg breaks at level k then we have n - 1 
					, eggDrop(n, k - x));//If the egg donot break then we have to check n eggs in k - x floors
			if(res < min)
				min = res;
		}
		
		return min + 1;
	}
	
	/**
	 * DP based approach to find the minimum number of egg drops.
	 * @param n
	 * @param k
	 * @return
	 */
	int dpEggDrop(int n, int k){
		
		int trials[][] = new int[n + 1][k + 1];
		int res;
		
		//If k in (0,1) then the number of trials is k
		for(int i = 0; i <= n; i++){
			trials[i][0] = 0;
			trials[1][1] = 1;
		}
		
		//If no. of eggs is 1 then no. of trials is k
		for(int i = 0; i <=k; i++)
			trials[1][i] = i;
		
		//Filling rest of the entries with optimal sub-structure property.
		for(int i = 2; i <= n; i++){
			for(int j = 2; j <= k; j++){
				trials[i][j] = Integer.MAX_VALUE;
				for(int x = 1; x <= j; x++){
					res = 1 + Math.max(trials[i - 1][x - 1], trials[i][j - x]);
					if(res < trials[i][j])
						trials[i][j] = res;
				}
			}
		}
		return trials[n][k];
	}
	
	public static void main(String[] args) {
		
		System.out.println(new EggDrop().eggDrop(2, 10));
		System.out.println(new EggDrop().dpEggDrop(2, 10));
		
	}
}
