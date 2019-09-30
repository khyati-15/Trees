import java.util.*;
import java.util.List;
import java.util.TreeMap; 
import java.util.Vector; 
import java.util.Map.Entry; 
import java.util.ArrayList;
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
	
	public static List<Integer> printlargestpath(Node node){
		if(node==null)
			return null;
		List<Integer> path=new ArrayList<>();
		path.add(node.getData());
		List<Integer> result=getmax(printlargestpath(node.getleft()),printlargestpath(node.getright()));
		if(result!=null)
			path.addAll(result);
		return path;
	}
	
	public static List<Integer> getmax(List<Integer> l1,List<Integer> l2){
		if(l1==null && l2==null)
			return null;
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		int maxleft=0,maxright=0;
		Iterator itr=l1.iterator();
		while(itr.hasNext())
			maxleft+=Integer.parseInt(itr.next().toString());
		itr=l2.iterator();
		while(itr.hasNext())
			maxright+=Integer.parseInt(itr.next().toString());
		if(maxleft>maxright)
			return l1;
		else
			return l2;
	}
	
	public static void main(String args[]){
		int path[]=new int[1000];
		
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		while(num!=-1){
			root=insert(root,num);
			num=sc.nextInt();
		}
		System.out.print("Longest Path :");
		List rpath=printlargestpath(root);
		Iterator itr=rpath.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next()+" ");
		}
		System.out.println();
	}
}
