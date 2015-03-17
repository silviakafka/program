package renren;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//import leetcode.addTwoNumbers.ListNode;

public class a {

	public static void main(String[] args) throws IOException
	{
		/*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
        System.out.println("请输入第一个数:");  
        String str1 = reader.readLine();  
        System.out.println(str1.length());
        System.out.println("请输入第二个数:");  
        String str2 = reader.readLine(); */
        System.out.println(addTwoNumbers("123","9"));
        System.out.println(addTwoNumbers("123","119"));
        
        
        
	}
	
	
	
	public static String addTwoNumbers(String num1,String num2)
    {
		//边界值特殊处理
		//保证.length .charAt操作不出现异常
		if(num1==null)
			return num2;
		if(num2==null)
			return num1;
		
		//边界值特殊处理
		//保证下面遍历时length2-1不为负数
		if(num1.length()==0)
			return num2;
		if(num2.length()==0)
			return num1;
		
		
		int length1=num1.length();
		int length2=num2.length();
		
		
		//保证num1 比num2长
		if(length1<length2)
		{
			String temp=num1;
			num1=num2;
			num2=temp;
			
			int tempN=length1;
			length1=length2;
			length2=tempN;
		}
		
		//思路：从num最后一位开始逆向遍历 并且相加。并记录进位
		//使用堆栈保存每一位相加的和
		Stack<Integer> myResult=new Stack();
		
		//开始设置进位为0
		int jinwei=0;
		//从num最后一位开始
		int place1=length1-1;
		for(int place2=length2-1;place2>=0;place2--)
		{
			int sum=(num1.charAt(place1)-'0')+(num2.charAt(place2)-'0')+jinwei;//用-'0'取出字符对应的数字
			if(sum>9)
			{
				sum=sum%10;
				jinwei=1;
			}
			else
				jinwei=0;
			
			myResult.push(sum);
			place1--;
			
		}
		//此时place2为-1
		for(;place1>=0;place1--)
		{
			if(jinwei>0)
			{
				int sum=(num1.charAt(place1)-'0')+jinwei;
				if(sum>9)
				{
					sum=sum%10;
					jinwei=1;
				}
				else
					jinwei=0;
				
				myResult.push(sum);
			}
			else//已经没有进位了
			{
				myResult.push((num1.charAt(place1)-'0'));
			}
		}
		
		//如果num1已经到底 还有进位的话
		if(jinwei!=0)
			myResult.push((num1.charAt(place1)-'0'));
		
		StringBuffer result=new StringBuffer();
		while(!myResult.isEmpty())
		{
			result.append(myResult.pop());
		}
    	return result.toString();
    }
	
	
	public String minusTwoNumbers(String num1,String num2)
	{
		//边界值特殊处理
		//保证.length .charAt操作不出现异常
		if(num1==null)
			return "-"+num2;
		if(num2==null)
			return num1;
		
		//边界值特殊处理
		//保证下面遍历时length2-1不为负数
		if(num1.length()==0)
			return "-"+num2;
		if(num2.length()==0)
			return num1;	
		
		int length1=num1.length();
		int length2=num2.length();
		
		//用于记录返回的是正数还是负数
		boolean flag=true;
		
		//保证num1 比num2长
		if(length1<length2)
		{
			//结果为负数
			flag=false;
			
			String temp=num1;
			num1=num2;
			num2=temp;
			
			int tempN=length1;
			length1=length2;
			length2=tempN;
		}
		//思路：从num最后一位开始逆向遍历 并且相减。并记录借位
		//使用堆栈保存每一位相加的和
		Stack<Integer> myResult=new Stack();
		
		
		
		
		if(length1==length2)
		{
			for(int i=0;i<length1;i++)
			{
				if(num1.charAt(i)>num2.charAt(i))
					break;
				else if(num1.charAt(i)==num2.charAt(i));
			}
		}
		
		
		
		
		
		
		//开始设置借位为0
		int jinwei=0;
		//从num最后一位开始
		int place1=length1-1;
		for(int place2=length2-1;place2>=0;place2--)
		{
			int minus=(num1.charAt(place1)-'0')-(num2.charAt(place2)-'0')-jinwei;//用-'0'取出字符对应的数字
			if(minus<0)
			{
				//借了一位
				minus=minus+10;
				jinwei=1;
			}
			else
				jinwei=0;
			
			myResult.push(minus);
			place1--;
			
		}		
		
		return null;
	}
	

}
