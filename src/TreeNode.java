import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void print(){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(this);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                System.out.print("null" + ", ");
                continue;
            }
            System.out.print(node.val + ", ");
            q.add(node.left);
            q.add(node.right);
        }
    }
}
