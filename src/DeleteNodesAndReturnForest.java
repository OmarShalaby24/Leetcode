import java.util.*;

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
//        root.print();
        List<TreeNode> forest = delNodes(root, new int[]{1});
        for (TreeNode node : forest){
            node.print();
            System.out.println();
        }

    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete){
            set.add(i);
        }
        deleteNode(root, set, forest, !set.contains(root.val));
        return forest;
    }

    public static TreeNode deleteNode(TreeNode root, Set<Integer> set, List<TreeNode> forest, boolean flag){
        if(root == null) return root;
        root.left = deleteNode(root.left, set, forest, set.contains(root.val));
        root.right = deleteNode(root.right, set, forest, set.contains(root.val));
        if(!set.contains(root.val) && flag)
            forest.add(root);
        return set.contains(root.val) ? null : root;
    }

}
