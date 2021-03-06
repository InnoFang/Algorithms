import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/*
The binary tree in this example is shown as follow

       1
     /   \
    2     3
   / \   /  
  4   5 6
     /
    7

post-order traversal: 4 7 5 2 6 3 1
*/

public class Main {

    public static void postorderTraversalByRecursion(TreeNode root) {
        if (root == null) return;
        postorderTraversalByRecursion(root.left);
        postorderTraversalByRecursion(root.right);
        System.out.print(root.val + " ");
    }
    
    public static void postorderTraversal(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        TreeNode pre = null;
        while (!nodeStack.empty()) {
            TreeNode cur = nodeStack.peek();
            if (cur.left != null && cur.left != pre && cur.right != pre) {
                nodeStack.push(cur.left);
            } else if (cur.right != null && cur.right != pre) {
                nodeStack.push(cur.right);
            } else {
                System.out.print(cur.val + " ");
                pre = cur;
                nodeStack.pop();
            }
        }
    }

    public static TreeNode generateBTree(Integer[] nodes, int index) {
        TreeNode node = null;

        if (index < nodes.length && nodes[index] != null) {
            node = new TreeNode(nodes[index]);
            node.left = generateBTree(nodes, index * 2 + 1);
            node.right = generateBTree(nodes, index * 2 + 2);
        }

        return node;
    }

    public static void main(String[] args) {
        Integer[] nodes = {1, 2, 3, 4, 5, 6, null, null, null, 7};
        
        TreeNode root = generateBTree(nodes, 0);

        postorderTraversalByRecursion(root);
        System.out.println();

        postorderTraversal(root);
        System.out.println();
    }
}