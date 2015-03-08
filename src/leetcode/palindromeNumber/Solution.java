package leetcode.palindromeNumber;

public class Solution {
	public static void main(String[] args)
	{
		//注意负数和0  还有溢出 对reverse方法稍加修改
		System.out.println(isPalindrome(-18273));
		System.out.println(isPalindrome(1000000003));
		
	}
	
	public static boolean isPalindrome(int x) {
        if(x<0)
        	return false;
        
        return (x==reverse(x));
    }
    public static long reverse(int x) {
        long num=0;
        long sum=0;
    	do{
    		num=x%10;
    		sum=sum*10+num;
    	}while((x=x/10)!=0);//注意不能是>0    因为可能为负数
    	
    	
    	return sum;	
    }
}
