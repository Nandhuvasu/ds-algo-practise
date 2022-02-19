import java.util.*;

public class ReverseTraversalOfTree {

    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int d){
            value = d;
        }
    }

    public static List<List<Integer>> reverseTraverseTree(TreeNode root){
        // initiate it as linkedlist so we can add levels to the front
        List<List<Integer>> results = new LinkedList<>();
        TreeNode currentNode = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(currentNode);
        while(!queue.isEmpty()){
            // get level size from queue
            int levelSize = queue.size();
            List<Integer> currentNodes = new ArrayList<>();
            for(int i=0; i< levelSize; i++){
                // get the node
                TreeNode pickedNode = queue.poll();
                currentNodes.add(pickedNode.value);
                if(pickedNode.left != null){
                    queue.add(pickedNode.left);
                }
                if(pickedNode.right != null){
                    queue.add(pickedNode.right);
                }
            }
            results.add(0, currentNodes);
        }
        return results;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = reverseTraverseTree(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}
