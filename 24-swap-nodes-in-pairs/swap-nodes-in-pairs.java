/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode reverse(ListNode head , int times)
    {
        ListNode curr= head;
        ListNode prev = null;
        while(times-- >0)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null)
        {
            return head;
        }
        ListNode left = head;
        ListNode right;
        ListNode prevLeft = null;
        ListNode res = null;
        int size =2;

        while(true)
        {       right = left;
            for(int i =0 ; i<size-1;i++)
            {
                if(right==null)
                {
                    break;
                }
                right = right.next;
            }
            if(right!=null)
            {
                ListNode nextLeft = right.next;
                ListNode newHead = reverse(left , size);
                if(prevLeft!=null)
                {
                    prevLeft.next=newHead; 
                }
                 if(res==null){
                        res=newHead;
                 }
                  left.next = nextLeft;
                  prevLeft = left;
                  left = nextLeft; 
                }
                else{
                    break;
                }
            }  
            if(res == null)
            {
                return head;
            }
             return res;
        }
    }
