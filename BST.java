/*************************************************************************
 *  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 3.0 1/11/15 16:49:42
 *
 *  @author Brian Farrell
 *  Eoin Pinaqui
 *  Yannick Gloster
 *
 *************************************************************************/

import javafx.scene.media.MediaMarkerEvent;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    /**
     * Private node class.
     */
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // return number of key-value pairs in BST
    public int size() { return size(root); }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    /**
     *  Search BST for given key.
     *  Does there exist a key-value pair with given key?
     *
     *  @param key the search key
     *  @return true if key is found and false otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     *  Search BST for given key.
     *  What is the value associated with given key?
     *
     *  @param key the search key
     *  @return value associated with the given key if found, or null if no such key exists.
     */
    public Value get(Key key) { return get(root, key); }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    /**
     *  Insert key-value pair into BST.
     *  If key already exists, update with new value.
     *
     *  @param key the key to insert
     *  @param val the value associated with key
     */
    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * Tree height.
     *
     * Asymptotic worst-case running time using Theta notation: Theta(N), as in the worst case this function will have the check
     * all branches and nodes in the tree to determine the deepest leaf.
     *
     * @return the number of links from the root to the deepest leaf.
     *
     * Example 1: for an empty tree this should return -1.
     * Example 2: for a tree with only one node it should return 0.
     * Example 3: for the following tree it should return 2.
     *   B
     *  / \
     * A   C
     *      \
     *       D
     */
    public int height()
    {
        return height(root);
    }

    private int height(Node tree) {
        int leftCount = 0; // count for left branch
        int rightCount = 0; // count for right branch
        if (tree == null)
        {
            return -1;
        }
        leftCount = height(tree.left); //count left branch
        rightCount = height(tree.right); //count right branch
        if (leftCount > rightCount) //return which branch has more nodes
        {
            return leftCount + 1;
        }
        else
        {
            return rightCount + 1;
        }
    }

    /**
     * Median key.
     * If the tree has N keys k1 < k2 < k3 < ... < kN, then their median key 
     * is the element at position (N+1)/2 (where "/" here is integer division)
     *
     * @return the median key, or null if the tree is empty.
     */
    public Key median() {
       if (isEmpty())
       {
           return null; //Empty trees have no median
       }
       int median = ((size(root)-1)/2); //Calculating the position in the Tree of the median key
       return median(root, median);
    }
    private Key median(Node tree, int rank) //this is a method that returns the node at a given rank, we pass the rank of median into this
    {
        int leafs = size(tree.left);
        if (leafs > rank) //determine if our median is to the left or right
        {
            return median(tree.left, rank); //recursion on the left branch
        }
        else if (leafs < rank)
        {
            return median(tree.right, rank-leafs-1); //recursion on the right branch
        }
        else
        {
            return tree.key;// found the median, return it.
        }
    }
    /**
     * Print all keys of the tree in a sequence, in-order.
     * That is, for each node, the keys in the left subtree should appear before the key in the node.
     * That is, for each node, the keys in the left subtree should appear before the key in the node.
     * Also, for each node, the keys in the right subtree should appear before the key in the node.
     * For each subtree, its keys should appear within a parenthesis.
     *
     * Example 1: Empty tree -- output: "()"
     * Example 2: Tree containing only "A" -- output: "(()A())"
     * Example 3: Tree:
     *   B
     *  / \
     * A   C
     *      \
     *       D
     *
     * output: "((()A())B(()C(()D())))"
     *
     * output of example in the assignment: (((()A(()C()))E((()H(()M()))R()))S(()X()))
     *
     * @return a String with all keys in the tree, in order, parenthesized.
     */
    public String printKeysInOrder() {
        return printKeysInOrder(root);
    }
    private String printKeysInOrder(Node tree)
    {
        String toPrint = ""; //String we will return
        if(tree == null)
        {
            return toPrint + "()";//null leaf
        }
        toPrint = toPrint + "(" + printKeysInOrder(tree.left);//print left keys before tree, recursion on left branch
        toPrint = toPrint + tree.key;//print the key of tree
        toPrint = toPrint + printKeysInOrder(tree.right) + ")";//print right keys after tree, recursion on right branch
        return toPrint;//every recursion will keep going until it reaches the end of its branch, at which point it will return its string until all branches form
                       // a single string.
    }
    /**
     * Pretty Printing the tree. Each node is on one line -- see assignment for details.
     *
     * @return a multi-line string with the pretty ascii picture of the tree.
     */
    public String prettyPrintKeys()
    {
        String prefix = ""; //prefix
        return prettyPrintKeys(root,prefix);
    }
    private String prettyPrintKeys(Node tree, String prefix)
    {
        String toPrint = "";
        if(tree == null)
        {
            toPrint = prefix + toPrint + "-null\n"; //empty node
            return toPrint;
        }
        toPrint = prefix + toPrint + "-" + tree.key + "\n"; //add key to string + prefix
        toPrint = toPrint + prettyPrintKeys(tree.left, prefix + " |");//go through left branch and add all its keys + add to the prefix
        toPrint = toPrint + prettyPrintKeys(tree.right, prefix + "  ");//go through right branch and add all its keys + add to the prefix
        return toPrint;//each branch will return all of its keys + a prefix based on its left and right branches that are added to toPrint and then returned
    }
    /**
     * Deteles a key from a tree (if the key is in the tree).
     * Note that this method works symmetrically from the Hibbard deletion:
     * If the node to be deleted has two child nodes, then it needs to be
     * replaced with its predecessor (not its successor) node.
     *
     * @param key the key to delete
     */
    public void delete(Key key) {
        if(!isEmpty())
        {
            root = delete(root, key);//only delete from non-empty trees
        }
    }
    private Node delete(Node tree, Key key)
    {
        int deleted = 0;//number of deletions for correcting the value of N
        if(tree != null)
        {
            if (tree.key.equals((key)))//we have found the key we want to delete
            {
                if (tree.left == null && tree.right == null) //key has no children so we can just delete it
                {
                    return null;
                }
                if(tree.left != null && tree.right == null) //key has only a left child so we can replace it with the left
                {
                    return tree.left;
                }
                else if(tree.right != null && tree.left == null) //key has only a right child so we can replace it with the right
                {
                    return tree.right;
                }
                else //tree has two children so we must find its predecessor
                {
                    Node replacement = findMax(tree.left); //predecessor is the Max node to the left, this will find it
                    Node temp = new Node(replacement.key, replacement.val, replacement.N);//creates a new node with the attributes of the predecessor
                    temp.left = tree.left; //set its children to be the children of the node we are deleting
                    temp.right = tree.right; //set its children to be the children of the node we are deleting
                    deleted++; //increment deleted counter
                    temp.left = delete(temp.left, temp.key); //we call deleted recursively until the entire branch is cleaned up, as the node we have found with findMax is still
                                                // in the tree and needs to be removed, will keep going until we reach an end node.
                    return temp;//return the new tree
                }
            }
            Node newNodeRight = delete(tree.right, key); //check the right of the tree for the node to delete
            tree.right = newNodeRight; //re-assign in case something has changed
            Node newNodeLeft = delete(tree.left, key); //check the left of the tree for the node to delete
            tree.left = newNodeLeft; //re-assign in case something has changed
            tree.N = tree.N - deleted; //fix value of N
        }
    return tree;
    }

    private Node findMax(Node tree)
    {
      Node temp = tree;
      while(temp.right!=null)
      {
          temp = temp.right;//keep going to the right until we find the deepest node, this is the max
      }
      return temp;//return the max
    }
}