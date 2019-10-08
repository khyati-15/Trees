import java.util.*;
class BTree{

	public static class Node{
	public int data;
	public Node left;
	public Node right;
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
	public static Node root=null;
	
	static int getLevel(Node root, Node node, int level) 
	{ 
	if (root == null) 
		return 0; 
	if (root == node) 
		return level; 
	int left = getLevel(root.left, node, level+1); 
	if (left != 0) 
		return left; 
	return getLevel(root.right, node, level+1); 
	} 


static void printGivenLevel(Node root, Node node, int level) 
{ 
	if (root == null || level < 2) 
		return; 
	if (level == 2) 
	{ 
		if (root.left == node || root.right == node) 
			return; 
		if (root.left != null) 
		System.out.print(root.left.data + " "); 
		if (root.right != null) 
		System.out.print(root.right.data + " "); 
	} 
	else if (level > 2) 
	{ 
		printGivenLevel(root.left, node, level-1); 
		printGivenLevel(root.right, node, level-1); 
	} 
} 

static void printCousins(Node root, Node node) 
{ 
	int level = getLevel(root, node, 1); 
	printGivenLevel(root, node, level); 
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

	public static Node find(Node root,int key){
		if(root==null || root.data==key)
			return root;
		if(root.data<key)
			return find(root.right,key);
		return find(root.left,key);
	}
	
	public static void main(String args[]){
		int path[]=new int[1000];
		
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		while(num!=-1){
			root=insert(root,num);
			num=sc.nextInt();
		}
		int key=sc.nextInt();
		printCousins(root,find(root,key));
	}
}
