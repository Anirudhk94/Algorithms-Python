/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LLCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        boolean result = false;
        
        while(fast.next != null && fast.next.next != null) {            
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) {
                return true;
            }
        }
        
        return result;
    }
}