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

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
    void print(){
        ListNode node = new ListNode(this.val, this.next);
        System.out.print(node.val);
        node = node.next;
        while(node != null){
            System.out.print("->"+node.val);
            node = node.next;
        }
    }
}
