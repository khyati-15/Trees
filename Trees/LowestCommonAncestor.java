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
	
	public static int LowestCommonAncestor(int num1,int num2,Node node){
		if(node==null)
			return 0;
		while(node!=null){
			if(node.getData()>num1 && node.getData()>num2){
				node=node.getleft();
			}
			else if(node.getData()<num1 && node.getData()<num2){
				node=node.getright();
			}
			else
				break;
		}
		return node.getData();
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
		
		System.out.println("Enter numbers : ");
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		int res=LowestCommonAncestor(num1,num2,root);
		System.out.println(res);
	}
}
