import java.util.*;

public class FindtheMinimumandMaximumNumberofNodesBetweenCriticalPoints {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2)))))));
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(new ListNode(3, new ListNode(1)))));
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(new ListNode(5, new ListNode(3, new ListNode(1, new ListNode(2, new ListNode(5, new ListNode(1, new ListNode(2))))))))));
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDistance = Integer.MAX_VALUE, maxDistance = Integer.MIN_VALUE;
        // if linked list size = 2 or 3
        if(head.next.next == null || head.next.next.next == null) return new int[]{-1, -1};

        List<Integer> indicesOfCriticalPoints = new ArrayList<>();

        int prevVal = head.val;
        head = head.next;
        int i=0;
        while(head != null && head.next != null){
            if(head.val > prevVal && head.val > head.next.val){
                indicesOfCriticalPoints.add(i);
            }
            else if(head.val < prevVal && head.val < head.next.val){
                indicesOfCriticalPoints.add(i);
            }
            prevVal = head.val;
            head=head.next;
            i++;
        }

        if(indicesOfCriticalPoints.size()<2) return new int[]{-1,-1};

        for(i=1; i<indicesOfCriticalPoints.size(); i++){
            minDistance = Math.min(minDistance, indicesOfCriticalPoints.get(i)-indicesOfCriticalPoints.get(i-1));
        }
        maxDistance = indicesOfCriticalPoints.get(indicesOfCriticalPoints.size()-1)-indicesOfCriticalPoints.get(0);

        return new int[]{minDistance, maxDistance};
    }
}
