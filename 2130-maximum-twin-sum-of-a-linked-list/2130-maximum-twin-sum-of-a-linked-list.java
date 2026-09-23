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
    public ListNode getMiddle(ListNode head){
        ListNode slow=head,fast=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode temp=head,prev=null,front=null;
        while(temp!=null){
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode middle=getMiddle(head);
        ListNode lastNode=reverse(middle);
        ListNode temp1=head,temp2=lastNode;
        int sum=0,maxSum=Integer.MIN_VALUE;
        while(temp1!=middle){
            sum=temp1.val+temp2.val;
            maxSum=Math.max(maxSum,sum);
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return maxSum;
    }
}