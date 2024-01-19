/*Infix To Postfix

Problem statement
You are given a string 'exp' which is a valid infix expression.



Convert the given infix expression to postfix expression.



Note:
Infix notation is a method of writing mathematical expressions in which operators are placed between operands. 

For example, "3 + 4" represents the addition of 3 and 4.

Postfix notation is a method of writing mathematical expressions in which operators are placed after the operands. 

For example, "3 4 +" represents the addition of 3 and 4.

Expression contains digits, lower case English letters, ‘(’, ‘)’, ‘+’, ‘-’, ‘*’, ‘/’, ‘^’. 


Example:
Input: exp = ‘3+4*8’

Output: 348*+

Explanation:
Here multiplication is performed first and then the addition operation. Hence postfix expression is  3 4 8 * +.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3^(1+1)

Expected Answer:
311+^


Output printed on console:
311+^


Explanation of Sample Input 1:
For this testcase, we will evaluate 'b' = (1+1) first. 

Hence it's equivalent postfix expression will be "11+". 

Next we will evaluate 3^b. It's equivalent postfix expression will be "3b^". 

Replacing 'b' with it's equivalent postfix we get "311+^".


Sample Input 2:
a+b+c+d-e


Expected Answer:
ab+c+d+e-


Output printed on console:
ab+c+d+e-


Expected Time Complexity:
Try to do this in O(n).


Constraints:
1 <= 'n' <= 5000 

‘n’, is the length of EXP
The expression contains digits, lower case English letters, ‘(’, ‘)’, ‘+’, ‘-’, ‘*’, ‘/’, ‘^’. 

Time Limit: 1 sec
*/

import java.util.Stack;
import java.util.HashMap;
public class Solution
{
    public static boolean isOperator(char ch) {
        if (ch - 'a' >= 0 && ch - 'a' <= 25) {
            return true;
        } else if (ch - '0' >= 0 && ch - '0' <= 9) {
            return true;
        } else {
            return false;
        }
    }

    public static String infixToPostfix(String exp) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> s = new Stack<>();

        // Precedence of the operators
        HashMap<Character, Integer> precedence = new HashMap<>();

        precedence.put('^', 3);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('(', 0);
        precedence.put(')', 0);

        for (int i = 0; i < exp.length(); i++) {
            if (isOperator(exp.charAt(i))) {
                ans.append(exp.charAt(i));
            } else if (exp.charAt(i) == ')') {

                // Remove till the last opening
                while (s.peek() != '(') {
                    ans.append(s.peek());
                    s.pop();
                }
                s.pop();
            } else if (exp.charAt(i) == '(') {
                s.push(exp.charAt(i));
            } else {

                // Remove lower precedence operators
                while (!s.isEmpty() && precedence.get(s.peek()) >= precedence.get(exp.charAt(i))) {
                    ans.append(s.peek());
                    s.pop();
                }
                s.push(exp.charAt(i));
            }
        }
        while (!s.isEmpty()) {
            ans.append(s.peek());
            s.pop();
        }
        return ans.toString();
    }
}