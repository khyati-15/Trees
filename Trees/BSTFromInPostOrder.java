import java.util.*;
class BTree{

	public static class Node{
	public int data;
	public Node left;
	public Node right;
	public Node(){
			
	}
	public Node(int ddata){
		data=ddata;
		left=null;
		right=null;
	}
	}
	
	static class Index{
		public int index;
	}
	
	public static int search(int arr[],int s,int e,int key){
		int i;
		for( i=s;i<=e;i++)
			if(arr[i]==key)
				return i;
		return i;
	}
	
	public static Node Tree(int in[],int post[],int sindex,int eindex,Index cindex){
		if(sindex>eindex)
			return null;
		Node node=new Node(post[cindex.index]);
		cindex.index--;
		if(sindex==eindex)
			return node;
		int i=search(in,sindex,eindex,node.data);
		node.right=Tree(in,post,i+1,eindex,cindex);
		node.left=Tree(in,post,sindex,i-1,cindex);
		return node;
	}
	
	public static Node buildTree(int in[],int post[],int N){
		Index i=new Index();
		i.index=N-1;
		return Tree(in,post,0,N-1,i);
	}
	
	public static void postorder(Node r){
		if(r!=null){
			System.out.print(r.data+" ");
			postorder(r.left);
			postorder(r.right);
			
		}
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of elements");
		int N=sc.nextInt();
		int in[]=new int[N];
		int post[]=new int[N];
		System.out.println("Enter inorder elements");
		for(int i=0;i<N;i++)
			in[i]=sc.nextInt();
		System.out.println("Enter postorder elements");
		for(int i=0;i<N;i++)
			post[i]=sc.nextInt();
		Node root=buildTree(in,post,N);
		postorder(root);
	}
}
