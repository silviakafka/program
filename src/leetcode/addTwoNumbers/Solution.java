package leetcode.addTwoNumbers;



class ListNode {
     int val;
     ListNode next;
      ListNode(int x) {
         val = x;
         next = null;
      }
	public ListNode() {
		// TODO Auto-generated constructor stub
	}
 }

public class Solution {
	
	public static void main(String[] args)
	{
		ListNode l1=new ListNode(5);
		ListNode l2=new ListNode(5);
		l1.next=new ListNode(9);
		ListNode result=new Solution().addTwoNumbers(l1, l2);
		while(result!=null)
		{
			System.out.print(result.val+" ");
			result=result.next;
		}
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    	if(l1==null)
    		return l2;
    	else if(l2==null)
    		return l1;
    	
    	ListNode head=new ListNode(0);
    	ListNode temp=head;
    	
    	int jinwei=0;
    	while(l1!=null&&l2!=null)
    	{
    		int sum=l1.val+l2.val+jinwei;
    		//sum只会在[0,18]之间 
    		if(sum>=10)
    		{
    			//这个和除以10的余数  加上前面一位的进位
    			sum=sum%10;
    			jinwei=1;
    		}
    		else
    			jinwei=0;
    		
    		ListNode newNode=new ListNode(sum);
    		temp.next=newNode;
    		temp=newNode;
    		l1=l1.next;
    		l2=l2.next;
    	}
    	
    	//注意  5   
    	//    5
    	//结果不是0  而是 0 1  注意最后进位问题
    	if(l1==null&&l2==null)
    	{
    		if(jinwei==0)
    			temp.next=null;
    		else
    		{
    			ListNode newNode=new ListNode(jinwei);
        		temp.next=newNode;
        		newNode.next=null;
    		}
    	}
    	else
    	{
    		//判断是谁先结束   notNull指向非空的链表
    		ListNode notNull=l1==null?l2:l1;

    		//还可能有好多类似的步骤  都是对单链表操作的  比如未结束的链表后面都是9 9  9 9  9  9 
    		while(notNull!=null&&jinwei!=0)
    		{
    			int sum=notNull.val+jinwei;
    			if(sum==10)
    			{
    				jinwei=1;
    				sum=0;
    			}
    			else
    				jinwei=0;
    			
    			ListNode newNode=new ListNode(sum);
        		temp.next=newNode;
        		temp=newNode;
        		notNull=notNull.next;
    		}
    		
    		//要么notNull为空了  要么jinwei为0了
    		if(jinwei==0)
    		{
    			temp.next=notNull;
    		}
    		else//进位不为0  notNull为空了
    		{
    			ListNode newNode=new ListNode(jinwei);
    			temp.next=newNode;
        		temp=newNode;
        		temp.next=null;
    		}
    			
    	}
    	
    	//注意上述过程 head是个空节点   从它后面一个才是第一个新节点
    	return head.next;
    	
    	/*int length1=getLength(l1);
    	int length2=getLength(l1);
    	//保证l1比l2长
    	if(length1<length2)
    	{
    		ListNode temp=l1;
    		l1=l2;
    		l2=temp;
    		int tempN=length1;length2=length1;length1=tempN;
    	}
    	
    	//此时l1比l2长
    	int gap=length1-length2;
    	ListNode temp=l1;
    	for(int i=1;i<=gap;i++)
    		temp=temp.next;
    	
    	//到了要合并的地方了
    	//用于记录前一位的进位记录
    	int jinwei=0;
    	while(l2!=null)
    	{
    		//得用temp，l1是链头 用于返回
    		int sum=temp.val+l2.val;
    		//sum只会在[0,18]之间 
    		if(sum>=10)
    		{
    			//这个和除以10的余数  加上前面一位的进位
    			sum=sum%10+jinwei;
    			jinwei=1;
    		}
    		else
    			jinwei=0;
    		
    		temp.val=sum;
    		temp=temp.next;
    		l2=l2.next;
    	}
    		
    	return l1;*/
    }

}
