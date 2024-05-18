public class DistributeCoinsInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0, new TreeNode(3), new TreeNode(0));
        System.out.println(distributeCoins(root));
    }
    static int moves = 0;
    public static int distributeCoins(TreeNode root){
        traverse(root);
        return moves;
    }

    public static int traverse(TreeNode node){
        if(node == null) return 0;
        int leftTraverse = traverse(node.left);
        int rightTraverse = traverse(node.right);

        moves +=  Math.abs(leftTraverse) + Math.abs((rightTraverse));
        return node.val + leftTraverse + rightTraverse -1;
    }
}
