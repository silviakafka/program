

public class LinkReverseRecurse {

	public static void main(String[] args)
	{
		int[] myArray=new int[]{1,3,5,86,8,24,35,55,29,84,54,37,56,2,69,6};
		LinkNode[] headAndTail=createLinklist(myArray);
		LinkNode head=headAndTail[0];
		
		printRecurse(head);
	}
	
	private static void printRecurse(LinkNode head) {
		if(head==null)
			return;
		printRecurse(head.next);
		System.out.print(head.data+" ");
		
	}

	private static LinkNode[] createLinklist(int[] myArray) {
		// TODO Auto-generated method stub
		LinkNode head=new LinkNode();
		head.data=myArray[0];
		head.prev=null;
		LinkNode current=head;
		for(int i=1;i<myArray.length;i++)
		{
			LinkNode node=new LinkNode();
			node.data=myArray[i];
			node.next=null;
			node.prev=current;
			current.next=node;
			current=node;
		}
		
		LinkNode[] headAndTail={head,current};
		return headAndTail;
	}
}

class LinkNode{
	int data;
	LinkNode next;
	LinkNode prev;
}
