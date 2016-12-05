package team_questions.tree_traversal;

//test class Tree and class TreeNode
public class TreeTest 
{
	public static void main(String[] args)
	{
	   Tree<Integer> tree = new Tree<Integer>();
	   Integer[] originalArray = {49, 28, 83, 18, 40, 71, 97, 11, 19, 32, 44, 69, 72, 92, 99};
	
	   System.out.println("Inserting the following values: ");
	
	   // insert 15 integers from original array in tree 
	   for (int i = 0; i < originalArray.length; i++) 
	   {
	      System.out.printf("%d ", originalArray[i]);
	      tree.insertNode(originalArray[i]);
	   } 
	   
	   System.out.printf("%n%nInorder traversal%n");
	   tree.inorderTraversal(); 
	
	   System.out.printf("%n%nPreorder traversal%n");
	   tree.preorderTraversal(); 
	
	   System.out.printf("%n%nPostorder traversal%n");
	   tree.postorderTraversal(); 
	   System.out.println();
	} 
} // end class TreeTest