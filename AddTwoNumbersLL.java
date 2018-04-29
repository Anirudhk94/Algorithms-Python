/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 *     Thi ssolution has a limitation due to the range of int in java
 * }
 */
class AddTwoNumbersLL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = "";
        String s2 = "";
    
        ListNode temp1 = reverseList(l1);
        ListNode temp2 = reverseList(l2);
        
        while(temp1 != null) {
            s1 = s1 + temp1.val;
            temp1 = temp1.next;
        }
        while(temp2 != null) {
            s2 = s2 + temp2.val;
            temp2 = temp2.next;
        }
        
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        
        int c = a + b;
        int m = c;
        
        ListNode head = null;
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(m != 0) {
            arr.add(m % 10);
            m = m/10;
        }
        
        ListNode prev = null;
        ListNode tempNode = null;
        
        for(int i = 0 ; i < arr.size() ; i++) {
            if( i == 0 ) {
                tempNode = new ListNode(arr.get(i));
                tempNode.next = null;
                prev = tempNode;
                head = prev;
            } else {
                tempNode = new ListNode(arr.get(i));
                tempNode.next = null;
                prev.next = tempNode;
                prev = tempNode;
            }
        }
        
        return head;
        
    }
    
    public ListNode reverseList(ListNode l1) {
        ListNode prev = null;
        ListNode next = l1;
        ListNode curr = l1;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
                
        return prev;
        
    }
}