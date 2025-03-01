
import java.util.PriorityQueue;

public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    
   class Solution {
      public ListNode deleteDuplicates(ListNode head) { 
           if(head==null){
               return head;
           }
           ListNode temp=head;
           while(temp.next!=null){
               if(temp.val==temp.next.val){
                   temp.next=temp.next.next;
               }
               else{
                   temp=temp.next;
               }
           }
           return head;
       }
      public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
           if (list1.val > list2.val) {
               cur.next = list2;
               list2 = list2.next;
           } else {
               cur.next = list1;
               list1 = list1.next;
           }
           cur = cur.next;
       }
        cur.next = (list1 != null) ? list1 : list2;
        return dummy.next;
   }
      public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
       while(fast!=null && fast.next!=null){
          fast=fast.next.next;
          slow=slow.next;
        if(fast==slow){
            return true;
        }
    }
    return false;
}
      public int Cyclelen(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
       while(fast!=null && fast.next!=null){
          fast=fast.next.next;
          slow=slow.next;
        if(fast==slow){
            ListNode temp=slow;
            int count=0;
            do{
                temp=temp.next;
                count++;
            }while(temp!=slow);
            return count;
        }
    }
    return 0;
}
      public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=findsqr(slow);
            fast=findsqr(findsqr(fast));
        }while(slow!=fast);
        if(slow==1){
            return true;
        }
        return false;
    }
      public int findsqr(int n){
        int ans=0;
        while(n>0){
            int rem=n%10;
            ans+=rem*rem;
            n=n/10;
        }
        return ans;
    }
      public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
       while(fast!=null && fast.next!=null){
          fast=fast.next.next;
          slow=slow.next;
    }
    return slow;
    }
      public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getmid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        left = sortList(left);
        right = sortList(right);
        return mergeTwoLists(left, right);
    }
      public ListNode getmid(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
       while(fast.next!=null && fast.next.next!=null){
          fast=fast.next.next;
          slow=slow.next;
        }
       return slow;
    }
      public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode prev=null;
        ListNode pres=head;
        ListNode next=pres.next;
        while(pres!=null){
            pres.next=prev;
            prev=pres;
            pres=next;
            if(next!=null){
                next=next.next;
            }
        }
        head= prev;
        return head;
    }
      public ListNode reverseList1(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
      public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
           return head;
       }
       ListNode current=head;
       ListNode prev=null;
       for(int i=1;current!=null && i<left;i++){
         prev=current;
         current=current.next;
       }
       ListNode next=current.next;
       ListNode newEnd=current;
       ListNode last=prev;
       for(int i=0;current!=null && i<=right-left;i++){
        current.next=prev;
        prev=current;
        current=next;
        if(next!=null){
            next=next.next;
        }
       }
       if(last!=null){
        last.next=prev;
       }
       else{
        head=prev;
       }
       newEnd.next=current;
       return head;
   }
      public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;

    // Step 1: Find the middle of the linked list
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Step 2: Reverse the second half of the list
    ListNode prev = null;
    ListNode pres = slow;
    ListNode next=pres.next;
    while (pres != null) {
        pres.next=prev;
        prev=pres;
        pres=next;
        if(next!=null){
            next=next.next;
        }               // Move to the next node
    }
    // Step 3: Compare the first half and the reversed second half
    ListNode left = head;
    ListNode right = prev; // Head of the reversed second half

    while (right != null) {
        if (left.val != right.val) {
            return false; // Not a palindrome
        }
        left = left.next;
        right = right.next;
    }

    return true; // It is a palindrome
}
      public ListNode reorderList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Step 2: Reverse the second half of the list
    ListNode prev = null;
    ListNode pres = slow;
    ListNode next=pres.next;
    while (pres != null) {
        pres.next=prev;
        prev=pres;
        pres=next;
        if(next!=null){
            next=next.next;
        }               // Move to the next node
    }
    // Step 3: Compare the first half and the reversed second half 
     ListNode first = head;
     ListNode second = prev; // This is the head of the reversed second half

        while (second.next != null) {
            ListNode temp1 = first.next; // Store the next node in the first half
            ListNode temp2 = second.next; // Store the next node in the second half

            first.next = second; // Link the first half to the second half
            second.next = temp1; // Link the second half back to the first half

            first = temp1; // Move first to the next node in the first half
            second = temp2; // Move second to the next node in the second half
        }
        return head;
    }
      public ListNode deleteDuplicatesII(ListNode node) {
        if(node==null){
              return node;
          }
          ListNode dummy=new ListNode(0);
          dummy.next=node;
          ListNode prev=dummy;
          while(node!=null){
              if(node.next != null &&node.val==node.next.val){
                   while (node.next != null && node.val == node.next.val) {
                   node = node.next;
                 }
                  prev.next = node.next;
              }
              else{
                  prev = prev.next; 
              }
              node = node.next; 
          }
          return dummy.next;
   }
      public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy=new ListNode(0);
    ListNode l3=dummy;
    int carry=0;
    while(l1!=null || l2!=null || carry>0 ){
        int dig1=(l1!=null)? l1.val:0;
        int dig2=(l2!=null) ? l2.val:0;
        int sum = dig1 + dig2 + carry;
        int digit = sum % 10;
        carry = sum / 10;
        ListNode newNode=new ListNode(digit);
        l3.next=newNode;
        l3=l3.next;
        l1 = (l1 != null) ? l1.next : null;
        l2 = (l2 != null) ? l2.next : null;
    }
    return dummy.next;
}
      public ListNode rotateRight(ListNode head, int k) {
         if (head == null || head.next == null || k == 0) {
           return head;
         }
         ListNode temp=head;
         int length=1;
         while(temp.next!=null){
            temp=temp.next;
            length++;
        }
        k=k%length;
        k=length-k;
        temp.next=head;
        while(k>0){
         temp=temp.next;
          k--;
        }
       head=temp.next;
       temp.next=null;
       return head;
}
      public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
       return head;
   }
   ListNode temp=head;
   int count=1;
   while(temp.next!=null){
       temp=temp.next;
       count++;
   }
   int a=count-n;
   temp=head;
  if(count==n) return head.next;

   for(int i=1;i<a;i++){
       temp=temp.next;
       }
   temp.next=temp.next.next;
   return head;
}
      public ListNode removeElements(ListNode head, int val) {
    ListNode dummy=new ListNode(0);
    dummy.next=head;
    ListNode curr = dummy;
    while(curr != null ){
        if(curr.next != null &&curr.next.val == val) {
            curr.next = curr.next.next;
        }
        else {
            curr = curr.next;
        }
    }
    return dummy.next;
}
      public void deleteNode(ListNode node) { //237
    node.val = node.next.val;
    node.next = node.next.next;
}
      public ListNode oddEvenList(ListNode head) {
    if(head == null) {
       return head;
   }
   ListNode slow = head;
   ListNode fast = head.next;
   ListNode fast2 = fast;
    while(fast!=null && fast.next!=null){
       slow.next = slow.next.next;
       fast.next = fast.next.next;
       fast = fast.next;
       slow = slow.next;
   }
   slow.next = fast2;
   return head;
}
      public ListNode sortLinkedList(ListNode head) {
    // Create dummy nodes for each of the three categories
    ListNode zeroHead = new ListNode(0);
    ListNode oneHead = new ListNode(0);
    ListNode twoHead = new ListNode(0);

    ListNode zeroTail = zeroHead;
    ListNode oneTail = oneHead;
    ListNode twoTail = twoHead;

    // Traverse the list and categorize nodes
    ListNode current = head;
    while (current != null) {
        if (current.val == 0) {
            zeroTail.next = current;
            zeroTail = zeroTail.next;
        } else if (current.val == 1) {
            oneTail.next = current;
            oneTail = oneTail.next;
        } else {
            twoTail.next = current;
            twoTail = twoTail.next;
        }
        current = current.next;
    }

    // Connect the three lists
    zeroTail.next = oneHead.next; // Connect 0's list to 1's list
    oneTail.next = twoHead.next; // Connect 1's list to 2's list
    twoTail.next = null; // End the list

    // Return the new head (skip the dummy node)
    return zeroHead.next != null ? zeroHead.next : (oneHead.next != null ? oneHead.next : twoHead.next);
}
      public ListNode plusOne(ListNode head) {
    // Reverse the linked list
    head = reverseList(head);
    
    ListNode current = head;
    ListNode lastNode = null;
    int carry = 1; // Start with the carry of 1
    
    // Add one to the number
    while (current != null) {
        int sum = current.val + carry;
        carry = sum / 10; // Update carry
        current.val = sum % 10; // Update current node's value
        lastNode = current; // Keep track of the last node
        current = current.next;
    }
    // If there's still a carry left, add a new n
    if (carry > 0) {
        lastNode.next = new ListNode(carry);
    }
    
    // Reverse the list again to restore the original order
    return reverseList(head);
}
      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null) return null;
 
         ListNode a = headA;
         ListNode b = headB;
 
 //if a & b have different len, then we will stop the loop after second iteration
       while( a != b){
     //for the end of first iteration, we just reset the pointer to the head of another linkedlist
         a=( a == null)? headB : a.next;
         b=(b == null)? headA : b.next;    
 }
 
 return b; 
 }
      public ListNode deleteMiddle(ListNode head) {
         ListNode fast=head;
         ListNode slow=head;
           if(head==null){
             return head;
              }
           if (head.next == null) return null;
           fast=fast.next.next;
             while(fast!=null && fast.next!=null){
              fast=fast.next.next;
              slow=slow.next;
              }
          slow.next=slow.next.next;
           return head;
        }
      public ListNode reverseKgroup(ListNode head,int k){
        ListNode temp = head;
        ListNode prevLast = null; // Track the last node of the previous group

        while (temp != null) {
            // Find the kth node
            ListNode kthNode = findKthnode(temp, k);

            // If kth node is null, it means there aren't enough nodes left to reverse
            if (kthNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp; // Link last node of previous group
                }
                break; // Exit the loop
            }

            // Store the next node after the kth node
            ListNode nextNode = kthNode.next;

            // Disconnect the kth node to prepare for reversal
            kthNode.next = null;

            // Reverse the group of nodes
            ListNode reversedHead = reverseList(temp);

            // If it's the first group, update the head
            if (prevLast == null) {
                head = reversedHead;
            } else {
                prevLast.next = reversedHead; // Link previous group's last node to reversed group
            }

            // Update prevLast to the end of the reversed group
            prevLast = temp;

            // Move to the next group
            temp = nextNode;
        }
        return head; // Return the modified head of the list
    }
      public ListNode findKthnode(ListNode temp, int k) {
       while(temp.next!=null && k>1){
        temp=temp.next;
        k--;
       }
       if(k==0)return temp;
       else return null;
    }
      public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
          return null; // Return null if input is empty
      }
      ListNode head=lists[0];
      for(int i=1;i<lists.length;i++){
           head=mergeTwoLists(head,lists[i]);
      }
      return head;
  }
      public ListNode mergeKLists1(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null; // Return null if input is empty
  }

  PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
      (a, b) -> Integer.compare(a.val, b.val) // Min-heap based on node values
  );

  // Add the head of each list to the min-heap
  for (ListNode list : lists) {
      if (list != null) {
          minHeap.add(list);
      }
  }

  ListNode dummy = new ListNode(0); // Dummy node to form the result list
  ListNode cur = dummy;

  while (!minHeap.isEmpty()) {
      ListNode smallestNode = minHeap.poll(); // Get the smallest node
      cur.next = smallestNode; // Link it to the result list
      cur = cur.next; // Move the current pointer forward

      // If there's a next node in the smallest node's list, add it to the heap
      if (smallestNode.next != null) {
          minHeap.add(smallestNode.next);
      }
  }

  return dummy.next; 

}
      public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) 
    return head;  
    ListNode curr = head.next.next; 
    ListNode prev = head; 
    head = head.next; 
    head.next = prev; 
// Fix remaining nodes 
    while (curr != null && curr.next != null) { 
       prev.next = curr.next; 
       prev = curr; 
       ListNode temp = curr.next.next; 
       curr.next.next = curr; 
       curr = temp; 
    } 
    prev.next = curr; 
    return head;
}
      public ListNode[] splitListToParts(ListNode head, int k) {
    ListNode [] res = new ListNode[k];
    int n = 0;
    ListNode curr = head;
    while (curr != null) {
        n += 1;
        curr = curr.next;
    }
    int size = n / k;
    int rem = n % k;
    curr = head;
    ListNode prev = head;
    for (int i = 0 ; i < k ; i++) {
        ListNode part = curr;
        int partSize = size;
        if (rem > 0) {
            rem -= 1;
            partSize += 1;
        }
        for (int j = 0 ; j < partSize ; j++) {
            prev = curr;
            curr = curr.next;
        }
        if (prev != null) prev.next = null;
        res[i] = part;
    }
    return res;
  } 
      public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        
        // Pointers for the two lists
        ListNode less = lessHead;
        ListNode greater = greaterHead;

        // Traverse the original list
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                less.next = current; // Add to the less list
                less = less.next;
            } else {
                greater.next = current; // Add to the greater list
                greater = greater.next;
            }
            current = current.next; // Move to the next node
        }

        // Connect the two partitions
        greater.next = null; // End the greater list
        less.next = greaterHead.next; // Connect less list to greater list
        return lessHead.next;
    }
      public ListNode removeNodes(ListNode head) {
        ListNode reversedHead = reverseList(head);
       
       // Step 2: Initialize variables for the new list
       ListNode newHead = null; // New list head
       ListNode current = reversedHead; // Pointer to traverse the reversed list
       int maxVal = Integer.MIN_VALUE; // To keep track of the maximum value

       // Step 3: Traverse the reversed list
       while (current != null) {
           if (current.val >= maxVal) {
               // If the current value is greater than or equal to maxVal,
               // add it to the new list
               ListNode newNode = new ListNode(current.val);
               newNode.next = newHead; // Insert at the front
               newHead = newNode; // Update newHead
               maxVal = current.val; // Update maxVal
           }
           current = current.next; // Move to the next node
       }

       // Step 4: Reverse the new list to restore original order
       return newHead;
   }
 
   public static void main(String[] args) {
            // Create a linked list: 1 -> 1 -> 2 -> 3 -> 3
            Solution solution = new Solution();

            // Create a linked list: 9 -> 9 -> 9 (represents the number 999)
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
    
            // Add one to the number
            ListNode result = solution.reorderList(head);
    
            // Print the resulting linked list
            ListNode current = result;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("null"); // Should output: 1 -> 0 -> 0 -> 0 -> null
       }
   }
