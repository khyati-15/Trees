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
	

public static int getleafcount(Node root){
  if(root==null)
    return 0;
  if(root.getleft()==null && root.getright()==null)
    return 1;
  return (getleafcount(root.getleft())+getleafcount(root.getright()));
}

public static int countallnodes(Node root){
   int count1 = 1;
    if (root.getleft() != null) {
       count1 += countallnodes(root.getleft());
    }
    if (root.getright() != null) {
        count1 += countallnodes(root.getright());
    }
    return count1;
}

public static int countLeafs(Node root) 
{
  if(root==null)
    return 0;
  return getleafcount(root);
}

public static int countNonLeafs(Node root) 
{
  if(root==null)
    return 0;
  return countallnodes(root)-getleafcount(root);
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
		System.out.println("Leaf Nodes : "+countLeafs(root));
		System.out.println("Non Leaf Nodes : "+countNonLeafs(root));
	}
}
