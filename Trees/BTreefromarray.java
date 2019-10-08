import java.util.*;

class Tree { 
  
    static class Node { 
        int data; 
        Node left, right; 
        Node(int data) 
        { 
            this.data=data; 
            left=null; 
            right=null; 
        } 
    } 
    Node root=null; 
    public Node insertLevelOrder(int[] arr, Node root, 
                                                int i) 
    { 
        if (i<arr.length){ 
            Node temp=new Node(arr[i]); 
            root=temp; 
            root.left=insertLevelOrder(arr,root.left,2*i+1); 
            root.right=insertLevelOrder(arr,root.right,2*i+2); 
        } 
        return root; 
    } 
  
    public void inorder(Node root) 
    { 
        if (root != null) { 
            inorder(root.left); 
            System.out.print(root.data + " "); 
            inorder(root.right); 
        } 
    } 
  
    public static void main(String args[]) 
    { 
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
        Tree t=new Tree(); 
		
        t.root=t.insertLevelOrder(arr,t.root,0); 
        t.inorder(t.root); 
    } 
} 