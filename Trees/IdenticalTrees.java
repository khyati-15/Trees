//Given a expression binary tree with 4 binary operators (+, -, *, /) and integer operands, evaluate it and print the answer.
//
//Complete the function evaluateTree() which takes the address of the root node of tree as parameter and return the result of expression.
//
//Note: The nodes with operators are given as ASCII codes of these operators (e.g. 42 for *(multiply), 43 for +(addition), 45 for -(subtraction) & 47 for /(division)).
//
import java.util.*;
import java.util.Stack; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.List;
import java.util.TreeMap; 
import java.util.Vector; 
import java.util.Map.Entry; 
class BTree{

	private static class Node{
	private int data;
	private Node left;
	private Node right;
	public Node(){
			
	}
	public Node(int num){
		data=num;
		left=null;
		right=null;
	}
	public int getData(){
		return data;
	}
	public Node getleft(){
		return left;
	}
	public void setleft(Node l){
		left=l;
	}
	public Node getright(){
		return right;
	}
	public void setright(Node l){
		right=l;
	}
	
	}
	
	public static Node insert(Node r,int num){
		if(r==null){
			Node newnode=new Node(num);
			r=newnode;
			return newnode;
		}
		else{
			if(r.getData()>num){
				r.setleft(insert(r.getleft(),num));			
			}
			else{
				r.setright(insert(r.getright(),num));
			}
		}
		return r;
	}
	
	public static boolean areSameTree(Node t1, Node t2)
	{
		if(t1==null && t2==null)
			return true;
		if(t1!=null && t2!=null)
			return (t1.getData()==t2.getData() && (areSameTree(t1.getleft(),t2.getleft())) && areSameTree(t1.getright(),t2.getright()));
		return false;
	}
	
	public static void main(String args[]){
		int path[]=new int[1000];
		Node root=null;
		Node root1=null;
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		while(num!=-1){
			root=insert(root,num);
			num=sc.nextInt();
		}
		int num1=sc.nextInt();
		while(num1!=-1){
			root1=insert(root1,num1);
			num1=sc.nextInt();
		}
		System.out.println(areSameTree(root,root1));
	}
}
