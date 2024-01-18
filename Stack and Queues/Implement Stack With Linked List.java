/*Implement Stack With Linked List

Problem statement
You must implement the Stack data structure using a Singly Linked List.



Create a class named 'Stack' which supports the following operations(all in O(1) time):



getSize: Returns an integer. Gets the current size of the stack

isEmpty: Returns a boolean. Gets whether the stack is empty

push: Returns nothing. Accepts an integer. Puts that integer at the top of the stack

pop: Returns nothing. Removes the top element of the stack. It does nothing if the stack is empty.

getTop: Returns an integer. Gets the top element of the stack. Returns -1 if the stack is empty
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
3 5
3 4
1
2
Sample Output 1:
2
false    
Explanation for Sample Output 1:
The first two queries ('3') push 5 and 4 on the stack. So the size of the stack becomes 2. 

Therefore the third query ('1') prints the size, and since the stack is not empty, the fourth and final query ('2') outputs "false"
Sample Input 2:
4
3 5
3 4
4
5
Sample Output 2:
5   
Explanation for Sample Output 2:
The first two queries ('3') push 5 and 4 on the stack.

The third query ('4') removes the top element of the stack, which is 4.

The fourth and final query ('5') prints the top element of the stack, 5
Constraints:
1 <= q <= 10^6
1 <= type <= 5
1 <= Data <= 2^31 - 1

Where 'type' is the type of query and 'Data' is the values getting pushed and popped from the stack. 

Time Limit: 1sec
*/
/****************************************************************

 Following is the class structure of the Node class:

 static class Node
 {
     int data;
     Node next;
     Node()
     {
         this.data = 0;
         this.next = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };


 *****************************************************************/
public class Solution {
    static class Stack {
        //Write your code here
       static Node head = null;
        Stack()
        {
            //Write your code here
        }

        int getSize()
        {
            //Write your code here
         Node temp = head;
         int size = 0;
         if(isEmpty()) {
             return size;
         } else {
             while(temp != null) {
                 size++;
                 temp = temp.next;
             }

         }
         return size;
        }

        boolean isEmpty()
        {
            //Write your code here
            return head == null;
        }

        void push(int data)
        {
            //Write your code here
           Node newNode = new Node(data);
           if(isEmpty()) {
               head = newNode;
               return;
           }
           newNode.next = head;
           head = newNode;
        }

        void pop()
        {
            //Write your code here
            if(isEmpty()){
                return ;
            }
            int top = head.data;
            head = head.next;
        }

        int getTop()
        {
            //Write your code here
           if(isEmpty()) {
               return -1;
           }
           return head.data;
        }
    }
}
