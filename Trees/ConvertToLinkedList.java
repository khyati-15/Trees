
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
	
	public static Node prev=null;
	public static Node head=null;
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
	
	public static void convertbst(Node node){
		if(node==null){
			
		}
		else{
			convertbst(node.getleft());
			node.setleft(prev);
			if(prev==null)
				head=node;
			else
			{
				node.setleft(prev);
				prev.setright(node);
			}
			prev=node;
			convertbst(node.getright());
		}
	}
	
	public static void main(String args[]){
		int path[]=new int[1000];
		Node root=null;
		
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		while(num!=-1){
			root=insert(root,num);
			num=sc.nextInt();
		}
		
		convertbst(root);
		Node trav=head;
		while(trav!=null){
			System.out.print(trav.getData()+" ");
			trav=trav.getright();
		}
	}
}
