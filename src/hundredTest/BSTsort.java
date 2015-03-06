package hundredTest;

public class BSTsort {

	public static void main(String[] args)
	{
		int[] num={3,45,66,73,95,46,77,120,343,5,34,78,94,520};
		Tree head=insertTree(num);
		
		int a=0;
		a++;
		Tree[] result=tree2Link(head);
		
		Tree node=result[0];
		while(node!=null)
		{
			System.out.print(node.num+"    ");
			node=node.right;
		}
		
		
	}


	


	private static Tree[] 	tree2Link(Tree head) {
		// TODO Auto-generated method stub
		
		if(head==null)
			return new Tree[]{null,null};
		
		Tree myLeft=null;
		Tree myRight=null;
				
		Tree[] left=tree2Link(head.left);
		Tree[] right=tree2Link(head.right);
		
		if(left[1]!=null)
		{
			left[1].right=head;
			head.left=left[1];
			myLeft=left[0];
		}
		else
		{
			myLeft=head;
		}
		
		if(right[0]!=null)
		{
			right[0].left=head;
			head.right=right[0];
			myRight=right[1];
		}
		else
		{
			myRight=head;
		}
		
		Tree[] result={myLeft,myRight};
		return result;
		
		
		
	
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

class Tree
{
	int num;
	Tree left;
	Tree right;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Tree getLeft() {
		return left;
	}
	public void setLeft(Tree left) {
		this.left = left;
	}
	public Tree getRight() {
		return right;
	}
	public void setRight(Tree right) {
		this.right = right;
	}
	
	
}
