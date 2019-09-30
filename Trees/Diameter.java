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
	
	public static int findheight(Node r){
		if(r==null)
			return 0;
		else
			return Math.max(findheight(r.getleft()),findheight(r.getright()))+1;
	}
	
	public static int find_diameter(Node node){
		if(node==null)
			return 0;
		int lheight=findheight(node.getleft());
		int rheight=findheight(node.getright());
		int ldiam=find_diameter(node.getleft());
		int rdiam=find_diameter(node.getright());
		return Math.max(lheight+rheight+1,Math.max(ldiam,rdiam));
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
		System.out.println("HEIGHT :"+findheight(root));
		System.out.println("Diameter:"+find_diameter(root));
	}
}
