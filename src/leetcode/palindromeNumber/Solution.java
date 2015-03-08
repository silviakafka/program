package leetcode.palindromeNumber;

public class Solution {
	public static void main(String[] args)
	{
		//ע�⸺����0  ������� ��reverse�����Լ��޸�
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
    	}while((x=x/10)!=0);//ע�ⲻ����>0    ��Ϊ����Ϊ����
    	
    	
    	return sum;	
    }
}
