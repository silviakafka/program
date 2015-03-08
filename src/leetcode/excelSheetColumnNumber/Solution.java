package leetcode.excelSheetColumnNumber;

public class Solution {
	
	public static void main(String[] args)
	{
		System.out.println(titleToNumber("AB"));
	}
	
    public static int titleToNumber(String s) {
        if(s==null||s.length()==0)
        	return 0;
        
        long num=0;
        long sum=0;
        
        int length=s.length();
        for(int i=0;i<length;i++)
        {
        	if(sum>Integer.MAX_VALUE)
        		return Integer.MAX_VALUE;
        	num=s.charAt(i)-'A'+1;
        	sum=sum*26+num;
        }
        
        return (int)sum;
    }
}