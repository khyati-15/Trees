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
		int index;
	}
	
	public static int search(int arr[],int s,int e,int key){
		int i;
		for( i=s;i<=e;i++)
			if(arr[i]==key)
				return i;
		return i;
	}
	
	public static Node Tree(int in[],int pre[],int sindex,int eindex,Index cindex){
		if(sindex>eindex)
			return null;
		Node node=new Node(pre[cindex.index]);
		cindex.index++;
		if(sindex==eindex)
			return node;
		int i=search(in,sindex,eindex,node.data);
		node.left=Tree(in,pre,sindex,i-1,cindex);
		node.right=Tree(in,pre,i+1,eindex,cindex);
		return node;
	}
	
	public static Node buildTree(int in[],int pre[],int N){
		Index i=new Index();
		i.index=0;
		return Tree(in,pre,0,N-1,i);
	}
	
	public static void postorder(Node r){
		if(r!=null){
			postorder(r.left);
			postorder(r.right);
			System.out.print(r.data+" ");
		}
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of elements");
		int N=sc.nextInt();
		int in[]=new int[N];
		int pre[]=new int[N];
		System.out.println("Enter inorder elements");
		for(int i=0;i<N;i++)
			in[i]=sc.nextInt();
		System.out.println("Enter preorder elements");
		for(int i=0;i<N;i++)
			pre[i]=sc.nextInt();
		Node root=buildTree(in,pre,N);
		postorder(root);
	}
}
