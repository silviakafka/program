package leetcode.atoi;

public class Solution {

	public static void main(String[] args)
	{
		System.out.println(atoi("18446744073709551617"));
	}
	
	
	public static int atoi(String str) {
		
			long num=0;
			long sum=0;
	        if(str==null)
	        	return 0;
	        
	        if(str.length()==0)
	        	return 0;
	        
	        
	        int i=0;
	        while(str.charAt(i)==' ')
	        {
	         	i++;
	         	if(i==str.length())
	         		return 0;
	         }
	        boolean flag=true;
	        if(str.charAt(i)=='-')
	        {
	        	flag=false;
	        	i++;
	        }
	        	
	        else if(str.charAt(i)=='+')
	        {
	        	flag=true;
	        	i++;
	        }
	        
	        if(i==str.length()) return 0;
	        
	        //开始第一个字符的判断
	        if(str.charAt(i)>'9'||str.charAt(i)<'0')
	        {
	        	return 0;
	        }
	        else
	        {
	        	int j=0;
	        	for(;i<str.length();i++)
	        	{
	        		if(str.charAt(i)>'9'||str.charAt(i)<'0')
	        		{
	        			if(sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE)
	        			{
	        				if(flag)
	        					return Integer.MAX_VALUE;
	        				else
	        					return Integer.MIN_VALUE;
	        			}
	        				
	        			
	        			else
	        			return flag?(int) sum:-(int) sum;
	        		}
	        		num=str.charAt(i)-'0';
	        		sum=sum*10+num;
	        	}
	        	
	        	if(sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE)
	        	{
	        		if(flag)
						return Integer.MAX_VALUE;
					else
						return Integer.MIN_VALUE;
	        	}
					
				else
					return flag?(int) sum:-(int) sum;
	        }
	        
	        
	   
	        
	       
	    }
}
