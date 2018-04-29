/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Here, I had a trouble identifying the following corner cases 
 *   1. addition of 1 + 99999
 *   2. returning the correct list (not always l1; always retrun the greater length ll)
 * 
 */
class AddTwoNumbersLL2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        ListNode temp1,temp2,prev;
        
        if(len2 > len1) {
            temp1 = l2;
            temp2 = l1;
        } else {
            temp1 = l1;
            temp2 = l2;
        }

        prev = temp1;
        int carry = 0;
        
        while(temp2 != null && temp1 != null) {
            int x = temp1.val + temp2.val + carry;
            if(x > 9) {
                carry = 1;
                x = x % 10;
            } else {
                carry = 0;
            }
            
            temp1.val = x;
            
            prev = temp1;
            temp1 = temp1.next;
            temp2 = temp2.next; 
        }
        
        while(carry == 1) {
            if(temp1 != null) {
                int x = temp1.val + carry;
                if(x > 9) {
                    carry = 1;
                    x = x % 10;
                } else {
                    carry = 0;
                }

                temp1.val = x;

                prev = temp1;
                temp1 = temp1.next;            
            }
            else{
                prev.next = new ListNode(1);
                carry = 0;
            }
                
        }
        
        if(len2 > len1) {
            return l2;
        } else {
            return l1;
        }
        
        
    }
    
    public int getLength(ListNode l1) {
        ListNode temp = l1;
        int len = 0;
        
        while(temp != null) {
            len += 1;
            temp = temp.next;
        }
        return len;
    }
}