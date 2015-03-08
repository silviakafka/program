package dataStructure;


public class Hoffmantree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] x=new int[]{3,18,6,4,35,66,30,12};
		
		
		LinkNode result=hoffmanMethod(x);
		
		//前序遍历生成的赫夫曼树
		preorderTreeWalk(result);
		
	}
	
	
	

	private static LinkNode hoffmanMethod(int[] x) {
		//先将int数组转换为双向的Node链表
		//headAndTail[0]代表链的头  headAndTail[1]代表链尾
		LinkNode[] headAndTail=createLinklist(x);
		
		
		//使用快速排序对链表排序
		//quickSort函数应该是没有问题的  单独测试过
		quickSort(headAndTail[0],headAndTail[1]);
		
		//用于代表取出的头两个节点
		LinkNode head1;
		LinkNode head2;
		//用于代表合成的节点
		LinkNode treeHead;
		
		while(true)
		{
			//用于代表取出的头两个节点
			head1=headAndTail[0];
			head2=head1.next;
			//合成节点
			treeHead=new LinkNode(head1.data+head2.data);
			treeHead.left=head1;
			treeHead.right=head2;
			
			//如果是最后两个节点了  则跳出循环
			if(head2.next==null)
				break;
			
			//去掉头两个节点
			//将合成的节点放回到原来的双链表中
			
			//1.建立treeHead和链表的关联
			treeHead.next=head2.next;
			head2.next.prev=treeHead;
			//2.将新连表头设置为treeHead
			headAndTail[0]=treeHead;
			quickSort(headAndTail[0],headAndTail[1]);
		}
		
		return treeHead;
		
		
		
	}
	
	
	
	
	
	//下面多个为已经验证过的函数，可直接用的函数*********************************************************
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
	
	
	private static void preorderTreeWalk(LinkNode head) {
		// TODO Auto-generated method stub
		if(head==null)
			return;
		System.out.println(head.data);
		preorderTreeWalk(head.left);
		preorderTreeWalk(head.right);
	}

}



class LinkNode{
	public LinkNode(int i) {
		data=i;
	}
	
	
	public LinkNode() {
		super();
	}


	int data;
	LinkNode next;
	LinkNode prev;
	
	LinkNode left;
	LinkNode right;
}

