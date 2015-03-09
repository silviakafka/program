package leetcode.reverseInteger;

public class Solution {
	public static void main(String[] args)
	{
		System.out.println(-6%10);
		//此题注意负数！！！！
		System.out.println(reverse(-1641));
		
		//反转的数也可能overflow  溢出！！！！  eg:the reverse of 1000000003 overflows
		System.out.println(reverse(1000000003));
	}
	
    public static int reverse(int x) {
        long num=0;
        long sum=0;
    	do{
    		num=x%10;
    		sum=sum*10+num;
    	}while((x=x/10)!=0);//注意不能是>0    因为可能为负数
    	
    	if(sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE)
    		return 0;
    	
    	return (int)sum;	
    }
}
