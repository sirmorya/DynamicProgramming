package DynamicProgramming;

/**
 * This class is used to determine the rectangle having the highest sum of elements  in a 2-D matrix.
 * 
 * @author ankitsirmorya
 *
 */
public class MaxSumRectangle {

	private static int row = 4;
	private static int col = 5;
	private static int start;
	private static int finish;
	
	public static void main(String[] args) {
		int M[][] = {{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
               };

		computeMaxRectangle(M);

	}
	
	/**
	 * This method returns the largest continous sum in an array.
	 *  
	 * @param a
	 * @return
	 */
	static int kadane(int a[]){
		
		int sum = 0, maxSum = Integer.MIN_VALUE , localStart = 0;
		
		finish =-1;
		
		for(int i = 0; i< a.length ; i++){
			sum += a[i];
			if(sum < 0){
				sum =0;
				localStart = i +1;
			}else if(sum > maxSum){
				maxSum = sum;
				start = localStart;
				finish = i;
			}
		}
		
		if(finish != -1){
			return maxSum;
		}
		
		
		// If all elements are negative
		maxSum = a[0];
		for(int i = 1; i < a.length ; i++){
			if(a[i] > maxSum){
				maxSum = a[i];
				start = finish = i;
			}
		}
		
		return maxSum;
		
	}
	
	static void computeMaxRectangle(int a[][]){
		
		int temp[] = new int[row];
		int sum, maxSum, finalLeft =0, finalRight = 0, finalTop = 0, finalBottom = 0; 
		 maxSum = Integer.MIN_VALUE;
		for(int left = 0; left < col ; left++){
			
			for( int right = left; right < col; right ++){
				
				for(int i = 0; i < row; i++)
					temp[i] += a[i][right];
				
				sum = kadane(temp);
				
				if(sum > maxSum){
					 maxSum = sum;
		                finalLeft = left;
		                finalRight = right;
		                finalTop = start;
		                finalBottom = finish;
				}
			}
		}
		
		System.out.println(finalTop +"," + finalLeft);
	    System.out.println( finalBottom +","+ finalRight);
	    System.out.println("Max sum is: \n" + maxSum);
	}
	
}
