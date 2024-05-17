import java.util.LinkedList;
import java.util.Queue;

public class DeleteLeavesWithGivenValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(2), null), new TreeNode(3, new TreeNode(2), new TreeNode(4)));
        removeLeafNodes(root, 2);
        root.print();

    }

    public static TreeNode removeLeafNodes(TreeNode root, int target){
        if(root == null) return root;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if(root.left == null && root.right == null && root.val == target){
            root = null;
            return root;
        }
        return root;

    }
}
