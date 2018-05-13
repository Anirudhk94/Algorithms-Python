/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * https://i.stack.imgur.com/TQoyH.png
 */
public class LLReturnLoopStart {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        ListNode result = null;
        boolean isLooped = false;
        
        while(fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) {
                isLooped = true;
                break;
            }
        }
        
        if(isLooped) {
            slow = head;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            result = slow;
        }
        
        return result;
    }
}