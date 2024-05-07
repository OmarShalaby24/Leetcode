import java.util.List;
import java.util.Stack;

public class RemoveNodesFromLinkedList {
    public static void main(String[] args) {
//        ListNode head = new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))));
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1)))));
        removeNodes(head).print();
    }

    public static ListNode removeNodes(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        ListNode node = head.next;
        while(node != null){
            while(!stack.isEmpty() && stack.peek().val < node.val){
                stack.pop();
            }
            stack.push(node);
            node = node.next;
        }
        ListNode tail = stack.pop();
        while(!stack.isEmpty()){
            head = stack.pop();
            head.next = tail;
            tail = head;
        }
        return tail;
    }
}


