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
	public void setData(int n){
		data=n;
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
	
	public static Node findMin(Node node){
		Node current=node;
		while(current.getleft()!=null)
			current=current.getleft();
		return current;
	}
	
	public static Node delete(Node r,int key){
		if(r==null){
			System.out.println("Value not found");
			return null;
		}
		
		if(key<r.getData()){
			r.setleft(delete(r.getleft(),key));
		}
		else if(key>r.getData()){
			r.setright(delete(r.getright(),key));
		}
		else{
			Node temp=null;
			if(r.getleft()==null && r.getright()==null)
				return null;
			else if(r.getleft()==null){
				temp=r.getright();
				return temp;
			}
			else if(r.getright()==null){
				temp=r.getleft();
				return temp;
			}
			else{
				temp=findMin(r.getright());
				r.setData(temp.getData());
				r.setright(delete(r.getright(),temp.getData()));
			}
		}
		return r;
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
	
	public static void inorder(Node r){
		if(r!=null){
			inorder(r.getleft());
			System.out.println(r.getData());
			inorder(r.getright());
		}
	}
	
	public static void main(String args[]){
		int path[]=new int[1000];
		
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		while(num!=-1){
			root=insert(root,num);
			num=sc.nextInt();
		}
		System.out.println("Enter value to be deleted");
		num=sc.nextInt();
		System.out.println("original tree");
		inorder(root);
		root=delete(root,num);
		System.out.println("after deletion");
		inorder(root);
	}
}
