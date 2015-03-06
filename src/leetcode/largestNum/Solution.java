package leetcode.largestNum;

public class Solution {
	
	public static void main(String[] args)
	{
		int[] test=new int[]{3, 30, 34, 5, 9};
		System.out.println(largestNumber(test));
	}
	
    public static String largestNumber(int[] num) {
        
    	
    	if(num.length==0)
    		return "";
    	

    	for(int i=0;i<num.length;i++)
        {
        	int number=num[i];
        	while(number>=10)
        	{
        		number=num[i]/10;
        	}
        }
    	return "";
    }
}
