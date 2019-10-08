import java.util.*;
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
	private static Node root=null;
	
	public static void inorder(Node r){
		if(r!=null){
			inorder(r.getleft());
			System.out.println(r.getData());
			inorder(r.getright());
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
	
	public static Node findmirror(Node root){
		if(root==null)
			return root;
		Node left=findmirror(root.getleft());
		Node right=findmirror(root.getright());
		root.setleft(right);
		root.setright(left);
		return root;
	}
	
	public static void main(String args[]){
		int path[]=new int[1000];
		
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		while(num!=-1){
			root=insert(root,num);
			num=sc.nextInt();
		}
		System.out.println("Inorder of original tree");
		inorder(root);
		Node mirror=findmirror(root);
		System.out.println("Inorder of mirror tree");
		inorder(root);
	}
}
