import java.util.*;

public class DefaultTraversalTree {

    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int d){
            value = d;
            left = null;
            right = null;
        }
    };

    public static List<List<Integer>> traverseTree(TreeNode root){
        List<List<Integer>> traversedNodes = new ArrayList<List<Integer>>();
        TreeNode currentNode = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            // get size of queue
            int currLevelSize = queue.size();
            System.out.println(currLevelSize);
            List<Integer> childNodeList = new ArrayList<>(currLevelSize);
            for(int i=0; i< currLevelSize; i++){
                TreeNode currNode = queue.poll();
                // add all of them to the array
                childNodeList.add(currNode.value);
                // add all of currentNode's children to queue
                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right !=null){
                    queue.offer(currNode.right);
                }
                System.out.println(queue.size());
                System.out.println(queue);
            }
            // add to results
            traversedNodes.add(childNodeList);
            System.out.println(traversedNodes);

        }
        return traversedNodes;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = traverseTree(root);
        System.out.println("Level order traversal: " + result);
    }
}
