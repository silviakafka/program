

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;



public class TreeFindParent {

	static Tree root=new Tree();
	static ArrayList<Tree> result1=new ArrayList<Tree>();
	static ArrayList<Tree> result2=new ArrayList<Tree>();
	
	public static void main(String[] args)
	{
		Tree a=new Tree();
		Tree b=new Tree();
			
		findParents(a,result1);
		findParents(b,result2);
	}

	private static void findParents(Tree a, ArrayList<Tree> result) {		
		if(a==root)
			return;
		Tree parent=findParent(a,root);
		result.add(parent);
		findParents(parent,result);
	}

	private static Tree findParent(Tree a, Tree start) {
		if(start==null)
		{}
			
		else if(start.left==a||start.right==a)
			return start;	
		
		findParent(a,start.left);
		findParent(a,start.right);		
		
		return null;
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
