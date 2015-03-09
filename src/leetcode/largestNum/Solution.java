package leetcode.largestNum;

public class Solution {
	
	public static void main(String[] args)
	{
		int[] test=new int[]{3, 30, 34, 5, 9};
		int[] test2=new int[]{121,12};
		int[] test3=new int[]{12,128};

		//测试快速排序本身是否正确
		/*quickSort(test,0,test.length-1);
		for(int t:test)
		{
			System.out.print(t+" ");
		}*/
		
		System.out.println(largestNumber(test3));
	}
	
    public static String largestNumber(int[] num) {
        
    	Node[] myNode=new Node[num.length];
    	transfer(myNode,num);
    	
    	if(num.length==0)
    		return "";
    	quickSort(myNode,0,myNode.length-1);
    	StringBuffer result=new StringBuffer();
    	for(int i=0;i<myNode.length;i++)
    	{
    		while(myNode[i]!=null)
    		{
    			result.append(myNode[i].num);
    			myNode[i]=myNode[i].next;
    		}
    	}
    	
    	//记录字符串开头有几个0
    	int z=0;
    	for(int k=0;k<result.length();k++)
    	{
    		if(result.charAt(k)=='0')
    			z++;
    		else
    			break;
    	}
    
    	if(z>1)
    	{
    		result.delete(0, z-1);
    	}
    	
    			
    	return result.toString();
    }

	private static void transfer(Node[] myNode, int[] num) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<num.length;i++)
		{
			int temp=num[i];
			//进行除法剩下的数
			int a=0;
			//进行取余剩下的数
			int b=0;
			do
			{
				b=temp%10;
				Node newNode=new Node((char)(b+'0'));
				//头插法
				Node tempNode=myNode[i];
				myNode[i]=newNode;
				newNode.next=tempNode;
			}while((temp=temp/10)>0);
		}
	}

	private static void quickSort(Node[] myNode,int left,int right) {
		// TODO Auto-generated method stub
		if(left>=right)
			return ;
		
		int place=findPlace(myNode,left,right);
		quickSort(myNode,left,place-1);
		quickSort(myNode,place+1,right);
		
	}

	private static int findPlace(Node[] myNode, int left, int right) {
		// TODO Auto-generated method stub
		int i=left;
		int j=left+1;
		
		for(;j<=right;j++)
		{
			if(compare(myNode,left,j))
			{
				i++;
				swap(myNode,i,j);
				continue;
			}
			else
			{
			}
		}
		swap(myNode,left,i);
		return i;
	}

	private static void swap(Node[] myNode, int i, int j) {
		// TODO Auto-generated method stub
		Node temp=myNode[i];
		myNode[i]=myNode[j];
		myNode[j]=temp;
	}

	
	//因为要逆序     i大的  返回false
	private static boolean compare(Node[] myNode, int i, int j) {
		// TODO Auto-generated method stub
		/*
		 * 用于做快速排序测试的
		 * boolean b=(num[i]>num[j]);
		b?true:false;*/
		Node node1=myNode[i];
		Node node2=myNode[j];
	
		while(node1!=null&&node2!=null)
		{
			if(node1.num>node2.num)
				return false;
			else if(node1.num<node2.num)
				return true;
			else if(node1.num==node2.num)
			{
				node1=node1.next;
				node2=node2.next;
			}
		}
		
		
		if(node1!=null)
		{
			Node tempN=myNode[i];
			while(node1!=null)
			{
				if(node1.num>tempN.num)
					return false;
				else if(node1.num<tempN.num)
					return true;
				else if(node1.num==tempN.num)
				{
					node1=node1.next;
					tempN=tempN.next;
				}
			}
			if(tempN.num>myNode[i].num)
				return true;
			else
				return false;
		}
			
		if(node2!=null)
		{
			Node tempN=myNode[j];
			while(node2!=null)
			{
				if(node2.num>tempN.num)
					return true;
				else if(node2.num<tempN.num)
					return false;
				else if(node2.num==tempN.num)
				{
					node2=node2.next;
					tempN=tempN.next;
				}
			}
			if(tempN.num>myNode[j].num)
				return false;
			else
				return true;
		}
		
				
		return false;
	}


}


class Node
{
	public Node(char b) {
		// TODO Auto-generated constructor stub
		num=b;
	}
	char num;
	Node next;
	}
