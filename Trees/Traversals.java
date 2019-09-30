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
	private static Node root=null;
	
	public static void setorder(Node node,int hd, TreeMap<Integer,Vector<Integer>> m){
		if(node==null){
			
		}
		else{
			Vector<Integer> g=m.get(hd);
			if(g==null){
				g=new Vector<>();
			}
			g.add(node.getData());
			m.put(hd,g);
			setorder(node.getleft(),hd-1,m);
			setorder(node.getright(),hd+1,m);
		}
	}
	
	public static void printverticalorder(Node node){
		TreeMap<Integer,Vector<Integer>> m=new TreeMap<>();
		int hd=0;
		setorder(node,hd,m);
		for(Entry<Integer,Vector<Integer>> e : m.entrySet())
			System.out.print(e.getValue()+" ");
	}
	
	public static void spiralorder(Node node){
		if(node==null){
		}
		else{
		Stack<Node> s1=new Stack<>();
		Stack<Node> s2=new Stack<>();
		s1.push(node);
		while(!s1.isEmpty() || !s2.isEmpty()){
			while(!s1.isEmpty()){
				Node temp=s1.peek();
				s1.pop();
				System.out.print(temp.getData()+" ");
				if(temp.getleft()!=null)
					s2.push(temp.getleft());
				if(temp.getright()!=null)
					s2.push(temp.getright());
			}
			
			while(!s2.isEmpty()){
				Node temp=s2.peek();
				s2.pop();
				System.out.print(temp.getData()+" ");
				if(temp.getright()!=null)
					s1.push(temp.getright());
				if(temp.getleft()!=null)
					s1.push(temp.getleft());
				
			}
		}
		}
	}
	
	public static void levelorder(Node node){
		if(node==null){
			
		}
		else{
			Queue<Node> q=new LinkedList<>();
			q.add(node);
			while(!q.isEmpty()){
				Node temp=q.poll();
				System.out.print(temp.getData() + " ");
				if(temp.getleft()!=null){
					q.add(temp.getleft());
				}
				if(temp.getright()!=null){
					q.add(temp.getright());
				}
			}
		}
	}
	
	public static void inordertraverse(Node r){
		Stack<Node> s=new Stack<Node>();
		Node curr=r;
		while(curr!=null || s.size()>0){
			while(curr!=null){
				s.push(curr);
				curr=curr.getleft();
			}
			curr=s.pop();
			System.out.println(curr.getData());
			curr=curr.getright();
		}
	}
	
	public static void inorder(Node r){
		if(r!=null){
			inorder(r.getleft());
			System.out.println(r.getData());
			inorder(r.getright());
		}
	}
	
	public static void preorder(Node r){
		if(r!=null){
			System.out.println(r.getData());
			preorder(r.getleft());
			preorder(r.getright());
		}
	}
	
	public static void postorder(Node r){
		if(r!=null){
			postorder(r.getleft());
			postorder(r.getright());
			System.out.println(r.getData());
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
	
	public static void main(String args[]){
		int path[]=new int[1000];
		
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		while(num!=-1){
			root=insert(root,num);
			num=sc.nextInt();
		}
		System.out.println("PRE");
		preorder(root);
		System.out.println("IN");
		inorder(root);
		System.out.println("IN WITHOUT RECURSION");
		inordertraverse(root);
		System.out.println("POST");
		postorder(root);
		System.out.println("Level Order Traversal : ");
		levelorder(root);
		System.out.println("\nVertical Order Traversal : ");
		printverticalorder(root);
		System.out.println("\nSpiral Order Traversal : ");
		spiralorder(root);
	}
}
