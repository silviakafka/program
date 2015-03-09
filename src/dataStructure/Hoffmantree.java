package dataStructure;


public class Hoffmantree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] x=new int[]{3,18,6,4,35,66,30,12};
		
		
		LinkNode result=hoffmanMethod(x);
		
		//ǰ��������ɵĺշ�����
		preorderTreeWalk(result);
		
	}
	
	
	

	private static LinkNode hoffmanMethod(int[] x) {
		//�Ƚ�int����ת��Ϊ˫���Node����
		//headAndTail[0]��������ͷ  headAndTail[1]������β
		LinkNode[] headAndTail=createLinklist(x);
		
		
		//ʹ�ÿ����������������
		//quickSort����Ӧ����û�������  �������Թ�
		quickSort(headAndTail[0],headAndTail[1]);
		
		//���ڴ���ȡ����ͷ�����ڵ�
		LinkNode head1;
		LinkNode head2;
		//���ڴ���ϳɵĽڵ�
		LinkNode treeHead;
		
		while(true)
		{
			//���ڴ���ȡ����ͷ�����ڵ�
			head1=headAndTail[0];
			head2=head1.next;
			//�ϳɽڵ�
			treeHead=new LinkNode(head1.data+head2.data);
			treeHead.left=head1;
			treeHead.right=head2;
			
			//�������������ڵ���  ������ѭ��
			if(head2.next==null)
				break;
			
			//ȥ��ͷ�����ڵ�
			//���ϳɵĽڵ�Żص�ԭ����˫������
			
			//1.����treeHead������Ĺ���
			treeHead.next=head2.next;
			head2.next.prev=treeHead;
			//2.��������ͷ����ΪtreeHead
			headAndTail[0]=treeHead;
			quickSort(headAndTail[0],headAndTail[1]);
		}
		
		return treeHead;
		
		
		
	}
	
	
	
	
	
	//������Ϊ�Ѿ���֤���ĺ�������ֱ���õĺ���*********************************************************
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
		//����quickSort(head,middle.prev)
		//��ʱmiddle�Ѿ��Ǳ�ͷ��  ��tailΪnull �޷�����tail.next  
		if(tail==null)
			return;
		// 3 5 7      9     10  ʱ   quickSort(middle.next,tail); ��middle.next==tail
		// 3 5 7 9          10 ʱ   quickSort(middle.next,tail)  middle.next==tail.next
		// 3   5        7 9 10 ʱ  quickSort(head,middle.prev)  ��head==middle.prev
		// 3          5 7 9 10 ʱ  quickSort(head,middle.prev) ��middle.prev==null  �����ڵ�������middle.prev.next�� 
		
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

