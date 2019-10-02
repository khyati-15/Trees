import java.util.*; 
class BTree{
	public static class Node{
	public int data;
	public Node leftChild;
	public Node rightChild;
	public Node(){
			
	}
	public Node(int num){
		data=num;
		leftChild=null;
		rightChild=null;
	}
	}
	static Node LevelOrder(Node n,int d){
    	if(n==null){
			n=new Node(d);
			return n;
    	}
    	if(d<=n.data)
			n.leftChild=LevelOrder(n.leftChild,d);
    	else
			n.rightChild=LevelOrder(n.rightChild,d);
		return n;
  	}
  
  	static Node buildSearchTree(int t[], int n) {
		Node root = null;
    // Complete the function body.
		for(int i=0;i<n;i++)
			root=LevelOrder(root,t[i]);
    	return (root);
  	}
	
	public static void inorder(Node r){
		if(r!=null){
			inorder(r.leftChild);
			System.out.println(r.data);
			inorder(r.rightChild);
		}
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of elements");
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		Node result=buildSearchTree(arr,n);
		inorder(result);
	}
}