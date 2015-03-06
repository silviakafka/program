package divideANDconquer;


//从一头向另一头移动  适用于链表型的快速排序
//链表的
//双链表


//单链表也可以实现
//写的那种 [head middle.prev]   不用prev [head, middle)

//左右都闭 和左闭右开

class LinkNode{
	int data;
	LinkNode next;
	LinkNode prev;
}


public class QuickSort4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] myArray=new int[]{1,3,5,86,8,24,35,55,29,84,54,37,56,2,69,6};
		LinkNode[] headAndTail=createLinklist(myArray);
		
		
		
		LinkNode head=headAndTail[0];
		
		LinkNode temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
		
		
		quickSort(headAndTail[0],headAndTail[1]);
		
		
		temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
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

	
	private static void quickSort(LinkNode head, LinkNode tail) {
		// TODO Auto-generated method stub
		//调用quickSort(head,middle.prev)
		//此时middle已经是表头了  则tail为null 无法调用tail.next  
		if(tail==null)
			return;
		// 3 5 7      9     10  时   quickSort(middle.next,tail); 则middle.next==tail
		// 3 5 7 9          10 时   quickSort(middle.next,tail)  middle.next==tail.next
		// 3   5        7 9 10 时  quickSort(head,middle.prev)  则head==middle.prev
		// 3          5 7 9 10 时  quickSort(head,middle.prev) 则middle.prev==null  不能在调用它的middle.prev.next了 
		
		if(head==tail||head==tail.next)
			return;
		LinkNode middle=findPlaceAndSort(head,tail);
		quickSort(head,middle.prev);
		quickSort(middle.next,tail);
		
	}
	private static LinkNode findPlaceAndSort(LinkNode head, LinkNode tail) {
		// TODO Auto-generated method stub
		int data=head.data;
		LinkNode i=head;
		LinkNode j=head.next;
		
		for(;j!=tail.next;j=j.next)
		{
			if(j.data<=data)
			{
				i=i.next;
				swap(i,j);
			}
		}
		swap(head,i);
		return i;
		
	}


	private static void swap(LinkNode i, LinkNode j) {
		// TODO Auto-generated method stub
		int datai=i.data;
		int dataj=j.data;
		i.data=dataj;
		j.data=datai;
	}



}
