import java.util.*;
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
	
	public static void printtopview(Node node){
		TreeMap<Integer,Vector<Integer>> m=new TreeMap<>();
		int hd=0;
		setorder(node,hd,m);
		for(Entry<Integer,Vector<Integer>> e : m.entrySet())
			System.out.print(e.getValue().get(0)+" ");
	}
	
	public static void printbottomview(Node node){
		TreeMap<Integer,Vector<Integer>> m=new TreeMap<>();
		int hd=0;
		setorder(node,hd,m);
		for(Entry<Integer,Vector<Integer>> e : m.entrySet())
			System.out.print(e.getValue().get(e.getValue().size()-1)+" ");
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
		System.out.println("\nTop View : ");
		printtopview(root);
		System.out.println("\nBottom View : ");
		printbottomview(root);
	}
}
