public class EvaluateBooleanBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,new TreeNode(1), new TreeNode(3, new TreeNode(0), new TreeNode(1)));
        System.out.println(evaluateTree(root));
    }

    public static boolean evaluateTree(TreeNode root){
        if(root.val == 0 || root.val == 1) return root.val == 1;
        else if(root.val == 2){
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        else if(root.val == 3){
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
        return false;
    }
}
