/*
 * Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 */
import java.util.*;
public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode reverseList(ListNode head) {
        
        if(head == null){
            return head;
        }
        
        Deque<Integer> stack = new ArrayDeque<>();

        ListNode current = head;
        int length = 0;

        while(current != null){
            //System.out.println(current.val);
            stack.push(current.val);
            current = current.next;
            length++;
        }

        ListNode new1 = head;
        for(int i = 0; i < length; i ++){
            //System.out.println(stack.peek());
            new1.val = stack.pop();
            new1 = new1.next;
        }

        return head;


    }
	//Definition for singly-linked list.
public class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	
	

}
