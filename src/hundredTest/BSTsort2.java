package hundredTest;

public class BSTsort2 {

	public static void main(String[] args)
	{
		int[] num={3,45,66,73,95,46,77,120,343,5,34,78,94,520};
		Tree head=insertTree(num);
		
		Tree[] t1=new Tree[2];
		t1=headAndTail(head);
		
		
	}


	private static Tree[] headAndTail(Tree node) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private static Tree[] Tree2Link(Tree node) {
		if (node == null) {
			Tree[] result=new Tree[2];
			return result;
		}
		Tree left = null, right = null;
		Tree[] leftLink = Tree2Link(node.left);
		Tree[] rightLink = Tree2Link(node.right);
		
		//如果node是个叶子节点
		//leftLink[]的结果是{null，null}
		//rightLink[]的结果是{null，null}
		if (leftLink[1]!=null) {
			leftLink[1].right = node;
			left = leftLink[0];
		}
		else {
			//则会进入这一步
			left = node;
		}
		node.left = leftLink[1];

		if (rightLink[0]!=null) {
			rightLink[0].left = node;
			right = rightLink[1];
		}
		else {
			//则也会进入这一步
			right = node;
		}
		node.right = rightLink[0];	
		//则返回{node,node}  这是错误的
		Tree[] result={left, right};
		return 	result; 
	}





	private static Tree insertTree(int[] num) {
		// TODO Auto-generated method stub
		Tree head=new Tree();
		head.num=num[0];
		Tree p;
		boolean flag=true;
		for(int i=1;i<num.length-1;i++)
		{
			flag=true;
			p=head;
			while(flag)
			{
				while(num[i]>p.num)
				{
					if(p.right==null)
					{
						Tree temp=new Tree();
						temp.num=num[i];
						p.right=temp;
						flag=false;
						break;
					}
					else
					{
						p=p.right;
					}
				}
				while(num[i]<p.num)
				{
					if(p.left==null)
					{
						Tree temp=new Tree();
						temp.num=num[i];
						p.left=temp;
						flag=false;
						break;
					}
					else
					{
						p=p.left;
					}
				}
			}
			
		}
		return head;
	}
	
	
	
	
	
}


