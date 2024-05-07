public class ListNode{
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
        System.out.println();
    }
}