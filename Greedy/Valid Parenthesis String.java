/* 678. Valid Parenthesis String

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true

 

Approach:- we will use 2 stacks, one for left parenthesis, and other for the star
we will store the indexes in these stacks, we will put the index
of the left parenthesis i.e openinig parenthesis
and the star into the stack, when we arrive at right or closing
parenthesis  check if any elements present in left, if yes, we pop it, 
Now again we come acrooss right parenthesis, but nothing left in left stack, we 
look at star stack, & pop it. At the end we get left & star stack both empty, If the
stack are not empty, we check if the left top index is less than right top, than 
means left occurs before star or not to form a valid pair. 

*/

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left, star;
        left = new Stack<>();
        star = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '(') left.push(i);
            else if(s.charAt(i) == '*') star.push(i);
            else {
                if(!left.isEmpty()) left.pop();
                else if(!star.isEmpty()) star.pop();
                else return false;
            }
        }
        while(left.size() != 0) {
            if(star.size() == 0) {
                return false;
            }

            if(star.peek() > left.peek()) {
                star.pop();
                left.pop();
            } else {
                return false;
            }
        }
        return true;
    }
}