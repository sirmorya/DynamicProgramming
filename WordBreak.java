package dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

	static String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
            "icecream","and","go","i","like","ice","cream","love"};
	static List dictList = Arrays.asList(dictionary);
	
	public static void main(String[] args) {
		/*System.out.println(dPWordBreak("ilikesamsung"));
		System.out.println(dPWordBreak("iiiiiiii"));
		System.out.println(dPWordBreak(""));
		System.out.println(dPWordBreak("ilikelikeimangoiii"));
		System.out.println(dPWordBreak("samsungandmango"));
		System.out.println(dPWordBreak("samsungandmangok"));*/
		//System.out.println(dPWordBreak("ilikeicecreamandmango"));
		String s= "iloveicecreamandmango";
		wordBreakUtil(s, s.length(), "");
	}
	
	
	/**
	 * This method is used to find all the possible outcomes in a string which lie in a dictionary.
	 * @param str
	 * @param size
	 * @param result
	 */
	static void wordBreakUtil(String str, int size , String result){
		
		for(int i=1; i<=size;i++){
			
			String prefix = str.substring(0,i); 
			if(dictList.contains(prefix)){
				
				if(i==size){
					result += prefix;
					System.out.println(result);
					return;
				}
				
				wordBreakUtil(str.substring(i,size), size-i, result+prefix+" ");
				
			}
		}
	}
	
	
	/**
	 * The recursive method to check if the string could be broken into smaller segments which are available in the dictionary.
	 * Here the same problem is computed many times. 
	 * @param str
	 * @return
	 */
	static boolean wordBreak(String str){
		
		// base case
		if(str == null || str.length() == 0) return true;
		
		for (int i=1; i<= str.length(); i++){
			
			// check whether the prefix exist or the remaining string could be broken
			if(dictList.contains(str.substring(0, i)) && wordBreak(str.substring(i)))
				return true;
		}
		
		return false;
		
	}
	
	/**
	 * This method is used to break the word using dynamic programming where the results of the subproblems are stored.
	 * @param str
	 * @return
	 */
	static boolean dPWordBreak(String str){
		if (str == null || str.length() ==0) return true;
		boolean wb[] = new boolean[str.length()+1];
		for(int i = 1; i<=str.length();i++){
			
			if(!wb[i] && dictList.contains(str.substring(0,i)))
				wb[i] = true;
			
			if(wb[i]){
				
				if(i == str.length()){
					printList(wb);
					return true;
				}
					
				for(int j = i+1; j<=str.length();j++){
					if(wb[j] == false && dictList.contains(str.substring(i,j)))
						wb[j] = true;
					if( j == str.length() && wb[j]){
						printList(wb);
						return true;
					}
						
				}
			}
			
		}
		
		
		
		return false;
		
	}
	
	
	static void printList(boolean[] list){
		for(boolean b:list){
			System.out.print(b?"Y ":"N ");
		}
	}
	
}
