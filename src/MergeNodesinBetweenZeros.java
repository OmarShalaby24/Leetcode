public class MergeNodesinBetweenZeros {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0))))))));
        mergeNodes(l1).print();
        ListNode l2 = new ListNode(0, new ListNode(1, new ListNode(0, new ListNode(3, new ListNode(0, new ListNode(2, new ListNode(2, new ListNode(0))))))));
        mergeNodes(l2).print();
        l2 = new ListNode(0, new ListNode(5, new ListNode(0)));
        mergeNodes(l2).print();

    }

    public static ListNode mergeNodes(ListNode head) {
        ListNode node = head;
        ListNode result = new ListNode();
        ListNode newNode = result;
        int sum = 0;
        while(node != null){
            if(node.val == 0){
                newNode.next = new ListNode(sum);
                newNode = newNode.next;
                sum = 0;
            }
            else{
                sum += node.val;
            }
            node = node.next;
        }
        return result.next.next;
    }

}
