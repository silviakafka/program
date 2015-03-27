package leetcode.ConvertSortedListtoBinarySearchTree;


// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; next = null; }
 }


// Definition for binary tree
class TreeNode {
     int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
	//方法2 将ListNode放入Vector  或者list里面 
	//可以用二分查找的方式随机查找了
	
	
	public static void main(String[] args)
	{
		int[] testArray=new int[]{3,5,8,9,12,13,18,26,45,56,70};
		ListNode test=convertFromArrayToList(testArray);
		TreeNode result=new Solution().sortedListToBST(test);
		inorderTreeWalk(result);
	}
	
    private static ListNode convertFromArrayToList(int[] testArray) {
		ListNode head=new ListNode(testArray[0]);
		ListNode temp=head;
		for(int i=1;i<testArray.length;i++)
		{
			ListNode l=new ListNode(testArray[i]);
			temp.next=l;
			temp=l;
		}
		return head;
	}
    private static void inorderTreeWalk(TreeNode head) {
		
    	if(head==null)
    	   return;
    	inorderTreeWalk(head.left);
    	System.out.println(head.val);
    	inorderTreeWalk(head.right);
    }


    
    
    
    
	public TreeNode sortedListToBST(ListNode head) {
    	
		if(head==null)return null;	
		
    	ListNode temp=head;
        int listLength=0;
    	for(;temp!=null;temp=temp.next)
    	{
    		listLength++;
    	}
    	return recuirseFindTreeHead(head,listLength);
        
    }
	private TreeNode recuirseFindTreeHead(ListNode head, int listLength) {
		
		if(listLength==0)
			return null;
		if(listLength==1)
			return new TreeNode(head.val) ;
		
		ListNode temp=head;
		int middlePlace=listLength/2;
		for(int step=middlePlace;step>0;step--)
		{
			temp=temp.next;
		}
		TreeNode n=new TreeNode(temp.val);
		n.left=recuirseFindTreeHead(head,middlePlace);
		n.right=recuirseFindTreeHead(temp.next,listLength-middlePlace-1);
		return n;
	}
}
