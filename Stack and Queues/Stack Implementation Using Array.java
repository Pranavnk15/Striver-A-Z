// Stack Implementation Using Array

// Problem statement
// Stack is a data structure that follows the LIFO (Last in First out) principle. Design and implement a stack to implement the following functions:

// 1. Push(num): Push the given number in the stack if the stack is not full.

// 2. Pop: Remove and print the top element from the stack if present, else print -1.

// 3. Top: Print the top element of the stack if present, else print -1.

// 4. isEmpty: Print 1 if the stack is empty, else print 0.

// 5. isFull: Print 1 if the stack is full, else print 0.


// You have been given ‘m’ operations which you need to perform in the stack. Your task is to implement all the functions of the stack.



// Example:
// We perform the following operations on an empty stack which has capacity 2:

// When operation 1 1 is performed, we insert 1 in the stack.

// When operation 1 2  is performed, we insert 2 in the stack. 

// When operation 2 is performed, we remove the top element from the stack and print 2.

// When operation 3 is performed, we print the top element of the stack, i.e., 3.

// When operation 4 is performed, we print 0 because the stack is not empty.

// When operation 5 is performed, we print 0 because the stack is size 1, which is not equal to its capacity.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1 :
// 2 6
// 1 1
// 1 2
// 2
// 3
// 4
// 5
// Sample Output 1 :
// 2 
// 1
// 0
// 0
// Explanation For Sample Output 1 :
// We perform the following operations on an empty stack which has capacity 2:

// When operation 1 1 is performed, we insert 1 in the stack.

// When operation 1 2  is performed, we insert 2 in the stack. 

// When operation 2 is performed, we remove the top element from the stack and print 2.

// When operation 3 is performed, we print the top element of the stack, i.e., 1.

// When operation 4 is performed, we print 0 because the stack is not empty.

// When operation 5 is performed, we print 0 because the stack is size 1, which is not equal to its capacity.
// Sample Input 2 :
// 5 5
// 1 2
// 2
// 2 
// 1 1
// 3
// Sample Output 2 :
// 2 
// -1
// 1
// Explanation For Sample Output 2 :
// We perform the following operations on an empty stack which has a capacity of 5:

// When operation 1 2 is performed, we insert 2 in the stack.

// When operation 2 is performed, we remove the top element from the stack and print 2.

// When operation 2 is performed, as the stack is empty, we print -1.

// When operation 1 1 is performed, we insert 1 in the stack.

// When operation 3 is performed, we print the top element of the stack, i.e., 1.
// Constraints :
// 1 <= 'n', 'm' <= 10^3

// Time Limit: 1 sec

public class Solution{
    static class Stack {
        int arr[];
        int n;
        int top;
        Stack(int capacity) {
            // Write your code here.
            arr = new int[capacity];
            n = capacity;
            top = -1;
        }
        public void push(int num) {
            top++;
            arr[top] = num;
        }
        public int pop() {
            // Write your code here.
    
                int temp = arr[top];
                arr[top] = 0;
                top--;
                return temp;
            
        }
        public int top() {
            // Write your code here.
            return arr[top];
        }
        public int isEmpty() {
            // Write your code here.
            if(top == -1) {
                return 1;
            } else {
                return 0;
            }
        }
        public int isFull() {
            // Write your code here.
            if(top == n-1) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}