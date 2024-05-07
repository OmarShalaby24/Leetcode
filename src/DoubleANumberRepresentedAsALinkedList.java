import java.util.Stack;

public class DoubleANumberRepresentedAsALinkedList {
    public static void main(String[] args) {
//        ListNode node = new ListNode(1,new ListNode(8, new ListNode(9)));
        ListNode node = new ListNode(9,new ListNode(9, new ListNode(9)));
        node.print();
        doubleIt(node).print();
    }

    public static ListNode doubleIt(ListNode head) {
        if(head.val > 4) head = new ListNode(0, head);

        ListNode node = head;
        while (node != null){
            node.val = (node.val*2) %10;
            if(node.next != null && node.next.val > 4){
                node.val++;
            }
            node = node.next;
        }
        return head;
    }
}
