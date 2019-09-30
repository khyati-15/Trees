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
	
	public static boolean checkbst(Node node){
		return isBST(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public static boolean isBST(Node node,int min,int max){
		if(node==null)
			return true;
		if(node.getData()<min || node.getData()>max)
			return false;
		return (isBST(node.getleft(),min,node.getData()) && isBST(node.getright(),node.getData(),max));
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
	
	public static void main(String args[]){
		int path[]=new int[1000];
		
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		while(num!=-1){
			root=insert(root,num);
			num=sc.nextInt();
		}
		if(checkbst(root))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
