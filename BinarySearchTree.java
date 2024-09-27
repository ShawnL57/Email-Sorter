import java.util.*;
import java.io.*;
public class BinarySearchTree {
   
   private TreeNode root;
   
   public BinarySearchTree() {
      root = null;
   }
   public void insert(Comparable next)
   {
      if(root == null)
         root = new TreeNode(next);
      
      
      TreeNode temp = insertHelper(root, next);
      if(temp != null)
      {
         if(((Integer)temp.getValue()).compareTo((Integer)next) > 0)
            temp.setLeft(new TreeNode(next));
         else
            temp.setRight(new TreeNode(next));
            
      }
         
   }
   private TreeNode insertHelper(TreeNode t, Comparable next)
   {
      if(t != null)
      {
         if(((Integer)t.getValue()).compareTo((Integer)next) > 0)
         {
            if(t.getLeft() == null)
               return t;
            return insertHelper(t.getLeft(),next);
            
         }
         else if(((Integer)t.getValue()).compareTo((Integer)next) <0)
         {
            if(t.getRight() == null)
               return t;
            return insertHelper(t.getRight(),next);
         }
         else
            return null;
      }
      return null;
      
   }
   
   public void printInOrder()
   {
      System.out.println("Inorder: ");
      printInOrderHelper(root);
      System.out.println();
   }
   private void printInOrderHelper(TreeNode t)
   {
      if(t != null)
      {
         printInOrderHelper(t.getLeft()); 
         System.out.print(t.getValue() + " ");
         printInOrderHelper(t.getRight());
        
      }
   }
   public void printPreOrder()
   {
      System.out.println("Preorder: ");
      printPreOrder(root);
      System.out.println();
   }
   private void printPreOrder(TreeNode t)
   {
      if(t!= null)
      {
         System.out.print(t.getValue() + " ");
         printPreOrder(t.getLeft());
         printPreOrder(t.getRight());
      }
      
   }
   public void printPostOrder()
   {
      System.out.println("Postorder: ");
      printPostOrder(root);
      System.out.println();
   }
   private void printPostOrder(TreeNode t)
   {
      if(t != null)
      {
         printPostOrder(t.getLeft());
         printPostOrder(t.getRight());
         System.out.print(t.getValue() + " ");
      }
   }
   public int countNodes()
   {
      return countNodesHelper(root);
   }
   private int countNodesHelper(TreeNode t)
   {
      if(t != null)
      {
         return 1 + countNodesHelper(t.getLeft()) + countNodesHelper(t.getRight());
      }
      return 0;
   }
   public Object find(Comparable target)
   {
      return findHelper(root, target);
   }
   private Object findHelper(TreeNode node, Comparable target)
   {
      if(node != null)
      {
         if(((Integer)node.getValue()).compareTo((Integer)target) == 0)
         {
            return node;
         }
         else if(((Integer)node.getValue()).compareTo((Integer)target) > 0)
         {
            return findHelper(node.getLeft(), target);
         }
         else
         {
            return findHelper(node.getRight(), target);
         }
      }  
      return null;
   }

   public void delete(Comparable target)
   {
      root = deleteHelper(root, target);
   }
   private TreeNode deleteHelper(TreeNode node, Comparable target)
   {
         if(node == null)
         {
            throw new NoSuchElementException();
         }
         else if (target.equals(node.getValue()))
         {
            return deleteTargetNode(node);
         }
         else if (target.compareTo(node.getValue()) < 0)
         {
            node.setLeft(deleteHelper(node.getLeft(), target));
            return node;
         }
         else
         {
            node.setRight(deleteHelper(node.getRight(), target));
            return node;
         }
   }
   private TreeNode deleteTargetNode(TreeNode target)
   {
   if (target.getRight() == null)   
   {
      return target.getLeft();
   }
   else if (target.getLeft() == null)
   {
      return target.getRight();  
   }
   else if (target.getLeft().getRight() == null)
   {
      target.setValue(target.getLeft().getValue());
      target.setLeft(target.getLeft().getLeft());
      return target;
   }
   else 
   {
   TreeNode marker = target.getLeft();
      while (marker.getRight().getRight() != null)
         marker = marker.getRight();
      target.setValue(marker.getRight().getValue());
      marker.setRight(marker.getRight().getLeft());
      return target;
   }
}   
      
   
   
}
